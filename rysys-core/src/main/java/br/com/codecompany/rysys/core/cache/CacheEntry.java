package br.com.codecompany.rysys.core.cache;

import java.io.Serializable;

public class CacheEntry {

	private Serializable response;
	private long maxTimeInCacheMillis;
	private long lastUpdateTime;

	public Serializable getResponse() {
		return response;
	}

	public void setResponse(Serializable response) {
		this.response = response;
	}

	public long getMaxTimeInCacheMillis() {
		return maxTimeInCacheMillis;
	}

	public void setMaxTimeInCacheMillis(long maxTimeInCache) {
		this.maxTimeInCacheMillis = maxTimeInCache;
	}

	public long getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(long lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
}
