package br.com.codecompany.rysys.iso8583.cache;

import br.com.codecompany.rysys.core.cache.AbstractCachingAspect;
import java.io.Serializable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Iso8583CachingAspect extends AbstractCachingAspect {

	@Pointcut("execution(java.io.Serializable " +
	"br.com.codecompany.rysys.iso8583.driver.Iso8583Adapter.execute(java.io.Serializable))")
	protected void adapterCommandExecution(){};

	@Override
	public String extractKey(Serializable command) {
		return String.valueOf(command);
	}
}
