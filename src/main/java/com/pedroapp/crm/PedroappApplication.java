package com.pedroapp.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
@EnableCaching
@EnableSpringDataWebSupport
@SpringBootApplication
public class PedroappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedroappApplication.class, args);
	}

}
