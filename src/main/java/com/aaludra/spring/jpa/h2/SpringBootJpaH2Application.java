package com.aaludra.spring.jpa.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.aaludra.spring.jpa.h2.service", "com.aaludra.spring.jpa.h2.controller" })
@EntityScan("com.aaludra.spring.jpa.h2.model")
public class SpringBootJpaH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaH2Application.class, args);

	}

}
