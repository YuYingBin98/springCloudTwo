package com.jk.yyb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TwoEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwoEurekaApplication.class, args);
	}

}
