package br.com.codecompany.rysys.core.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

import java.io.Serializable;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
public abstract class AbstractCachingAspect {

	private static Logger log = LoggerFactory.getLogger(AbstractCachingAspect.class);
	public static final long FOREVER = 0;

	// intercepta execucao do comando do Adapter
	@Pointcut("")
	protected abstract void adapterCommandExecution();

	// intercepta todas as execucoes de ConnectionDriver
	@Pointcut("adapterCommandExecution() && args(command)")
	protected void composite(Serializable command) {
	}

	// extrai a chave utilizada no cache
	public abstract String extractKey(Serializable command);

	// verifica se o comando esta no cache
	@Around("composite(command)")
	public Serializable executeUsingCache(ProceedingJoinPoint pjp,
			Serializable command) throws Throwable {

		Serializable response = null;

		// singleton
		Cache cache = Cache.getInstance();	// resultado da execucao do comando

		// chave do cache
		String key = extractKey(command);

		// o comando existe no cache
		if (cache.containsKey(key)) {
			CacheEntry entry = cache.get(key);
			// sempre no cache!
			if (entry.getMaxTimeInCacheMillis() == FOREVER) {
				// sempre recupera do cache
				log.info("Retrieving response from cache using key [{}]", key);
				response = entry.getResponse();
			} else {
				// calcula o tempo que a entrada esta no cache
				long timeInCache = System.currentTimeMillis() - entry.getLastUpdateTime();
				// entrada ainda eh valida
				if (timeInCache < entry.getMaxTimeInCacheMillis()) {
					log.info("Retrieving response from cache using key [{}]", key);
					entry.setLastUpdateTime(System.currentTimeMillis());
					response = entry.getResponse();
				} else {
					// entrada invalida, executa novamente
					log.info("Entry [{}] invalidated. Executing command...", key);
					response = (Serializable) pjp.proceed(new Object[]{command});
					// atualiza o cache
					entry.setResponse(response);
					entry.setLastUpdateTime(System.currentTimeMillis());
					cache.put(key, entry);
				}
			}
		} // comando nao existe, executa direto
		else {
			log.info("Entry not found in cache. Executing command...");
			response = (Serializable) pjp.proceed(new Object[]{command});
		}

		return response;
	}
}
