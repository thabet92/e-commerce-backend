package com.formation.e_commerce;

import javax.annotation.Resource;

import com.formation.e_commerce.File.StorageService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {
	@Resource
	StorageService storageService;


	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//storageService.deleteAll();
		//storageService.init();

	}
	@Bean
	BCryptPasswordEncoder getBCPE(){return new BCryptPasswordEncoder();}

}
