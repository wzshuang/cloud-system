package com.shuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigServer
public class CloudConfigApplication {

	@RequestMapping("/")
	public String home() {
		return "Hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigApplication.class, args);
	}
}
