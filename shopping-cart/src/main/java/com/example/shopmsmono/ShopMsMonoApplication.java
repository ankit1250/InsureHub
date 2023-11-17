package com.example.shopmsmono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@ComponentScan("com")
@EnableJpaRepositories("com.repo")
@EntityScan("com.entity")
@EnableEurekaClient
@OpenAPIDefinition(info = @Info(title = "user", description = "des", version = ""))
@CrossOrigin
public class ShopMsMonoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopMsMonoApplication.class, args);
	}

	@Bean("webclient")
	@LoadBalanced
	public WebClient.Builder getWebClient() {
		return WebClient.builder();
	}

}
