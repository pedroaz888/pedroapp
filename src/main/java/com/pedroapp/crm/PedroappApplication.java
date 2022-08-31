package com.pedroapp.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableCaching
@EnableSpringDataWebSupport
@SpringBootApplication

public class PedroappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedroappApplication.class, args);
		
		System.out.println(new BCryptPasswordEncoder().encode("8141"));
		System.out.println(new BCryptPasswordEncoder().encode("9090"));
	}

}
