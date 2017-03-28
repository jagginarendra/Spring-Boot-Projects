package com.bjs.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication(scanBasePackages={"com.bjs"})
@EnableMongoRepositories({"com.bjs.repository"})
//@EnableEurekaClient
@EnableCaching
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
	  JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();

	  // Defaults
	  redisConnectionFactory.setHostName("127.0.0.1");
	  redisConnectionFactory.setPort(6379);
	  return redisConnectionFactory;
	}
	
	
	@Bean
	  public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
	    RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
	    redisTemplate.setConnectionFactory(cf);
	    return redisTemplate;
	  }

	  @Bean
	  public CacheManager cacheManager(RedisTemplate redisTemplate) {
	    RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

	    // Number of seconds before expiration. Defaults to unlimited (0)
	    cacheManager.setDefaultExpiration(30);
	    return cacheManager;
	  }
	

}


