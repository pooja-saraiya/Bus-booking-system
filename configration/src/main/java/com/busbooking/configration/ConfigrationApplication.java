package com.busbooking.configration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigrationApplication.class, args);
	}

}
