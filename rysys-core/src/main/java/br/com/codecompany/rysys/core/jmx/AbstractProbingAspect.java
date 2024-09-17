package br.com.codecompany.rysys.core.jmx;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.codecompany.rysys.util.SocketUtils;
import br.com.codecompany.rysys.core.driver.ConnectionDriver;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import static br.com.codecompany.rysys.util.Constants.UNNAMED;

@Aspect
public abstract class AbstractProbingAspect {

	private static Logger log = LoggerFactory.getLogger(AbstractProbingAspect.class);
	protected static final Pattern REQUEST_PATTERN =
			Pattern.compile(".*\\<function\\>\\<name\\>(.+)\\<\\/name\\>.*", Pattern.DOTALL);

	// intercepta execucao do metodo do Adapter
	@Pointcut("")
	protected abstract void adapterMethodExecution();

	// intercepta todas as execucoes de ConnectionDriver
	@Pointcut("adapterMethodExecution() && args(command) && target(support)")
	protected void composite(Serializable command, ConnectionDriver support) {
	}

	@Around("composite(command, support)")
	public Object around(Serializable command, ConnectionDriver support,
			ProceedingJoinPoint thisJoinPoint) throws Throwable {

		String source = "127.0.0.1";
		String target = "127.0.0.1";
		String functionName = UNNAMED;
		long startTime = 0;
		long endTime = 0;
		boolean valid = false;

		try {
			valid = isValidFunction(command);
			if (valid) {
				log.debug("Command execution intercepted: [" + command + "]");
				source = SocketUtils.getHostName();
				target = String.valueOf(support.getHostname())
						+ ":" + String.valueOf(support.getPort());
				functionName = extractFunctionName(command);
				startTime = System.nanoTime();
			} else {
				log.debug("Command execution intercepted but ignored: [" + command + "]");
			}
		} catch (Exception e) {
			log.error("Error intercepting command execution", e);
		}

		try {
			Serializable result = (Serializable) thisJoinPoint.proceed();
			if (valid) {
				endTime = System.nanoTime();
				long total = (endTime - startTime) / 1000000;
				try {
					AdapterMBeanProxy.getInstance().insertSuccess(source, target,
							functionName, total, String.valueOf(command),
							String.valueOf(result));
				} catch (Exception e) {
					log.error("Error inserting monitoring data", e);
				}
			}
			return result;
		} catch (Throwable t) {
			if (valid) {
				try {
					AdapterMBeanProxy.getInstance().insertError(source, target,
							functionName, String.valueOf(command));
				} catch (Exception e) {
					log.error("Error inserting monitoring data", e);
				}
			}
			throw t;
		}
	}

	// extrai o nome da funcao a partir da linha de comando enviada ao EIS
	protected String extractFunctionName(Serializable command) {
		String request = String.valueOf(command);
		log.trace("Extracting function name from [{}]", request);
		String name = UNNAMED;
		if (command != null && !"".equals(request.trim())) {
			Matcher matcher = REQUEST_PATTERN.matcher(request);
			if (matcher.matches()) {
				name = matcher.group(1);
				log.trace("Function name is: '{}'", name);
			}
		}
		return name;
	}

	// verifica se a funcao deve ser tratada
	protected boolean isValidFunction(Serializable command) {
		boolean valid = false;
		String request = String.valueOf(command);
		log.trace("Verifing if the function is valid [{}]", request);
		if (command != null && !"".equals(request.trim())) {
			Matcher matcher = REQUEST_PATTERN.matcher(request);
			valid = matcher.matches() && matcher.groupCount() > 0;
			log.debug("Valid function [{}]?: {}", request, valid);
		}
		return valid;
	}
}
