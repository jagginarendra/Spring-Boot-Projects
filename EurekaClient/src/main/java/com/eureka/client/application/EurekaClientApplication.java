package com.eureka.client.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages={"com.eureka"})
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrix
public class EurekaClientApplication {


	public static void main(String[] args) {

		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate RestTemplate() {
		
		return new RestTemplate();

	}

}
