package com.hallak.eurekaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaAppApplication.class, args);
	}

}
