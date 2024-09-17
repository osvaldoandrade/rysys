package br.com.codecompany.rysys.iso8583.jmx;

import java.io.Serializable;
import java.util.Map;

import br.com.codecompany.rysys.core.jmx.AbstractProbingAspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Iso8583ProbingAspect extends AbstractProbingAspect {

	@Pointcut("execution(java.io.Serializable " +
	"br.com.codecompany.rysys.iso8583.driver.Iso8583Adapter.execute(java.io.Serializable))")
	protected void adapterMethodExecution() {};
	
	@Override
	protected String extractFunctionName(Serializable command) {
		Map<Integer, String> map = (Map<Integer, String>) command;
		
		String transmissionChannel = map.get(33);
		if (transmissionChannel == null) {
			transmissionChannel = "VALUE-OF-BIT-33";
		}
		
		String processingCode = map.get(3);
		if (processingCode == null) {
			processingCode = "VALUE-OF-BIT-3";
		}
		
		return transmissionChannel + "_" + processingCode;
	}
	
	@Override
	protected boolean isValidFunction(Serializable command) {
		return true;
	}
}