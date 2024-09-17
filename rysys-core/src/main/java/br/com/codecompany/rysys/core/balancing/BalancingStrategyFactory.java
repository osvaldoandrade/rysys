package br.com.codecompany.rysys.core.balancing;

import static br.com.codecompany.rysys.core.balancing.BalancingStrategy.ROUND_ROBIN;
import static br.com.codecompany.rysys.core.balancing.BalancingStrategy.SINGLE_SERVER;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BalancingStrategyFactory {

	private static final Logger log = LoggerFactory.getLogger(BalancingStrategyFactory.class);

	public static final BalancingStrategy getStrategy(String type) {
		BalancingStrategy strategy = null;
		
		if (type == null || "".equals(type.trim())) {
			log.warn("No balancing strategy specified. Using " + SINGLE_SERVER);			
			type = SINGLE_SERVER;
		}
		
		type = type.trim().toUpperCase();
		if (SINGLE_SERVER.equals(type)) {
			strategy = new SingleServerBalancingStrategy();
		} 
		else if (ROUND_ROBIN.equals(type)) {
			strategy = new RoundRobinBalancingStrategy();
		}
		else {
			try {
				Class<?> clazz = Class.forName(type);
				strategy = (BalancingStrategy) clazz.newInstance();
			} catch (Exception e) {
				log.error("Can't initialize '" + type + "'. Valid strategies are: " +
					  "SINGLE_SERVER, ROUND_ROBIN or a full name of a class " +
					  "which implements " + BalancingStrategy.class.getSimpleName(), e);
			}
		}
		
		if (strategy == null) {
			throw new InvalidBalancingStrategyException("'" + type
					+ "' is not a valid server balancing strategy");
		}
		
		return strategy;
	}
}
