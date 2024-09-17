package br.com.codecompany.rysys.fgl.cache;

import br.com.codecompany.rysys.core.cache.AbstractCachingAspect;
import java.io.Serializable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class FglCachingAspect extends AbstractCachingAspect {

	@Pointcut("execution(java.io.Serializable " +
	"br.com.codecompany.rysys.fgl.driver.FglAdapter.execute(java.io.Serializable))")
	protected void adapterCommandExecution(){};

	@Override
	public String extractKey(Serializable command) {
		return String.valueOf(command);
	}
}