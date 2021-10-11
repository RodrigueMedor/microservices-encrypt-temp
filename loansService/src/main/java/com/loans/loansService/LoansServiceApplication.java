package com.loans.loansService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@RefreshScope
@ComponentScans({ @ComponentScan("com.loans.loansService.controller") })
@EnableJpaRepositories("com.loans.loansService.repository")
@EntityScan("com.loans.loansService.model")

public class LoansServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansServiceApplication.class, args);
	}

}
