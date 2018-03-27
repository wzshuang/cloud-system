package com.shuang;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {

	@Value("${bar}")
	String bar;

	@RequestMapping("/")
	public String bar() {
		return String.format("bar: %s", bar);
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
