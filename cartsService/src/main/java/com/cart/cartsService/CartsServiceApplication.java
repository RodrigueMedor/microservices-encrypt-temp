package com.cart.cartsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScans({@ComponentScan("com.cart.cartsService.controller")})
@EnableJpaRepositories("com.cart.cartsService.repository")
@EntityScan("com.cart.cartsService.domain")
public class CartsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartsServiceApplication.class, args);
	}

}
