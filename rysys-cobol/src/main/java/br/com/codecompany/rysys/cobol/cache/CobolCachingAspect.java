package br.com.codecompany.rysys.cobol.cache;

import br.com.codecompany.rysys.core.cache.AbstractCachingAspect;
import java.io.Serializable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CobolCachingAspect extends AbstractCachingAspect {

	@Pointcut("execution(java.io.Serializable " +
	"br.com.codecompany.rysys.cobol.driver.CobolAdapter.execute(java.io.Serializable))")
	protected void adapterCommandExecution(){};

	@Override
	public String extractKey(Serializable command) {
		return String.valueOf(command);
	}
}