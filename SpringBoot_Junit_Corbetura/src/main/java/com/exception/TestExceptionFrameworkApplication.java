package com.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories({"com.exception.repository"})
public class TestExceptionFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestExceptionFrameworkApplication.class, args);
	}
}
