package com.example.policypurchasedservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@Configuration
@ComponentScan("com")
@EnableJpaRepositories("com.repo")
@EntityScan("com")
@OpenAPIDefinition(info=@Info(title="user",description="des",version=""))
@CrossOrigin
public class OrderServiceApplication
{
	
	public static void main(String[] args) 
	{
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean("webclient")
	@LoadBalanced
	public WebClient.Builder getwebClient()
	{
		return WebClient.builder();
	}
}
