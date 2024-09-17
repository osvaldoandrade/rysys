package br.com.codecompany.rysys.api.function;

import br.com.codecompany.rysys.api.executor.ExecutionResult;
import br.com.codecompany.rysys.api.executor.FunctionExecutionException;
import static br.com.codecompany.rysys.util.Constants.UNNAMED;

import br.com.codecompany.rysys.core.jca.eis.IEisConnection;
import java.io.Serializable;
import javax.resource.cci.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractFunction implements Function {

	private static final Logger log = LoggerFactory.getLogger(AbstractFunction.class);

	private String name = UNNAMED;

	public AbstractFunction(String name, Object... optionalParams) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

    public ExecutionResult invoke(Connection connection) {
    	ExecutionResult result = null;
        try {
            log.info("Executing function '{}'", getName());

            Serializable command = getProtocol().extractCommand(this);
            IEisConnection eisConn = (IEisConnection) connection;

            log.info("Executing command [{}]", command);
            Serializable res = eisConn.execute(command);
            log.info("Raw result from EIS [{}]", res);

            result = getProtocol().extractResult(res);

            log.warn("Function executed. Connection is still open");

        } catch (Exception e) {
            throw new FunctionExecutionException("Error executing function", e);
        }

        log.info("Function result: [{}]", result);
        return result;
    }
}
