package com.pedroapp.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@EnableCaching
@SpringBootApplication
public class PedroappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedroappApplication.class, args);
	}

}
