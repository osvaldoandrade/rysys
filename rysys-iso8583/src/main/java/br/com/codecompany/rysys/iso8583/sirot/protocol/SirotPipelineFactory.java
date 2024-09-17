package br.com.codecompany.rysys.iso8583.sirot.protocol;

import java.util.concurrent.TimeUnit;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.timeout.IdleStateHandler;
import org.jboss.netty.util.HashedWheelTimer;

import br.com.codecompany.rysys.iso8583.sirot.SirotAdapter;

public class SirotPipelineFactory implements ChannelPipelineFactory {
	
	private SirotAdapter adapter;
	private int timeout;
	private int idleTimeout;
	private HashedWheelTimer timer = new HashedWheelTimer();
	
	public SirotPipelineFactory(SirotAdapter adapter) {
		this.adapter = adapter;
		this.timeout = adapter.getTimeout();
		this.idleTimeout = timeout * 10;
	}
	
	public ChannelPipeline getPipeline() {
		ChannelPipeline pipeline = Channels.pipeline();
		
		pipeline.addLast("idleTimeout",  new IdleStateHandler(timer, 
				idleTimeout, idleTimeout, idleTimeout, TimeUnit.MILLISECONDS));	
		
		pipeline.addLast("handler", new SirotMessageDecoder(adapter));
		
		return pipeline;
	}
}