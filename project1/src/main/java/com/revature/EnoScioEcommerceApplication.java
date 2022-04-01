package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class EnoScioEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnoScioEcommerceApplication.class, args);
	}

}
