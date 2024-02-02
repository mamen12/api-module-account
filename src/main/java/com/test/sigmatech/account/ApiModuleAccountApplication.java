package com.test.sigmatech.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.test.sigmatech.account", "com.commons.beans" })
public class ApiModuleAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiModuleAccountApplication.class, args);
	}

}
