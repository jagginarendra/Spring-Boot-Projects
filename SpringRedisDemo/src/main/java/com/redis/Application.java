package com.redis;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@SpringBootApplication
public class Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		LOGGER.info("container Initializeds");
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, new PatternTopic("chat"));

		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		LOGGER.info("adapter Initializeds");
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	@Bean
	Receiver receiver(CountDownLatch latch) {
		LOGGER.info("receiver latch");
		return new Receiver(latch);
	}

	@Bean
	CountDownLatch	latch(){
		LOGGER.info("countdown latch");
		return new CountDownLatch(1);
	}
	
	@Bean
	StringRedisTemplate template(RedisConnectionFactory factory){
		LOGGER.info("returning template using factory");
		return new StringRedisTemplate(factory);
	}
	
	
	public static void main(String[] args) throws InterruptedException {

		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		StringRedisTemplate template = context.getBean(StringRedisTemplate.class);
		
		CountDownLatch latch = context.getBean(CountDownLatch.class);
		
		LOGGER.info("Sending Message...");
		
		template.convertAndSend("chat", "this is redis!!!");
		
		latch.await();
		
		System.exit(0);
	}
}
