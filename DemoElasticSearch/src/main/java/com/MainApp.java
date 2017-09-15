package com;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {

		SpringApplication.run(MainApp.class, args);
	}

}

@RestController
class Demo {

	@RequestMapping(value = "/hello")
	public String getMessage() {

		
		
		return buildRestClient();
	}

	private String buildRestClient() {

		RestClient restClient = null;

		restClient = RestClient.builder(new HttpHost("localhost", 9200, "http")).build();

		RestHighLevelClient restHighLevelClient = new RestHighLevelClient(restClient);

		GetRequest getRequest = new GetRequest("productcatalog", "product", "prod2168");
		Header headers = new BasicHeader("Content-Type", "application/json");
		GetResponse getResponse = null;
		try {
			
			 getResponse = restHighLevelClient.get(getRequest, headers);
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return getResponse.toString();
	}
}
