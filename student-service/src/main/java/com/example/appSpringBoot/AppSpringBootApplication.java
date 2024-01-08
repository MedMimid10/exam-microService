package com.example.appSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.appSpringBoot.repositories")
@EntityScan(basePackages = "com.example.appSpringBoot.model")

public class AppSpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppSpringBootApplication.class, args);
	}

}
