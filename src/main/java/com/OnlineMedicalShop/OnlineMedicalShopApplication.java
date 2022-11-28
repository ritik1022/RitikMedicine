package com.OnlineMedicalShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages="com.Medicine")
@EntityScan(basePackages="com.OnlineMedicalShop.model")
@EnableJpaRepositories(basePackages="com.OnlineMedicalShop.repository")
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.OnlineMedicalShop")
public class OnlineMedicalShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMedicalShopApplication.class, args);
		System.out.println("Server running");
	}

}
