package com.hallak.configBichoMS;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class ConfigBichoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigBichoMsApplication.class, args);
	}

}
