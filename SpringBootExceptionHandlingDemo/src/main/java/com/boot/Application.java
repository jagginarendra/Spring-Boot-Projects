package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages={"com.boot.rest.controller","com.boot"})
//@EnableWebMvc
public class Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}
}

@RestController
class Demo{
	
	//@GetMapping(value = "/testing" , produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/testing")
	public String test(){
		System.out.println("testing");
		return "working fine";
	}
}