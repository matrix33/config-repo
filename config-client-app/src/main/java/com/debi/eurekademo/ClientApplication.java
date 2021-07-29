package com.debi.eurekademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	
	@Autowired
	ConfigClientAppConfiguration config;
	
	@Value("${some.other.property}")
	private String someOtherProperty;
	
	@RequestMapping("/")
	public String printConfig() {
		StringBuilder sb = new StringBuilder();
		sb.append(config.getProperty()).append(" || ").append(someOtherProperty);
		return sb.toString();
	}

}
