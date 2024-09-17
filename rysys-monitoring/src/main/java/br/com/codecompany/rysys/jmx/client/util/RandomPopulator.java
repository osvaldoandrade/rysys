package br.com.codecompany.rysys.jmx.client.util;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import br.com.codecompany.rysys.jmx.client.JmxProxy;
import static br.com.codecompany.rysys.jmx.client.Constants.JMX_URL;
public class RandomPopulator extends Timer {

	private static final int VALUE = 10;
	private static final int FREQUENCY_MS = 1000 * 5;
	
	public RandomPopulator(JmxProxy proxy, int interval) {
		schedule(new PopulatorTask(proxy),
				new Date(System.currentTimeMillis()), interval);
	}

	public static void main(String[] args) throws Exception {
		JmxProxy proxy = JmxProxy.getInstance(JMX_URL, null);
		new RandomPopulator(proxy, FREQUENCY_MS);
	}
	
	class PopulatorTask extends TimerTask {
		private JmxProxy proxy;

		public PopulatorTask(JmxProxy proxy) {
			this.proxy = proxy;
		}

		@Override
		public void run() {
			int errors = (int)(Math.random() * VALUE);
			int success = (int)(Math.random() * VALUE);
			
			// insere erros
			for (int i = 0; i < errors; i++) {
				int index = (int)(Math.random() * VALUE);
				proxy.insertError("localhost", "localhost", "function_" + index,
						"request_" + index);
			}
			
			// insere sucessos
			for (int i = 0; i < success; i++) {
				int index = (int)(Math.random() * VALUE);
				proxy.insertSuccess("localhost", "localhost", 
						"function_" + index, (float) Math.random(),
						"request_" + index, "response_" + index);
			}			
		}
	}
}
