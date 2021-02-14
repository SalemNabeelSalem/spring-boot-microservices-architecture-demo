package com.springbootmicroservices.serviceadministrator;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAdminServer
@EnableEurekaClient
@SpringBootApplication
public class ServiceAdministratorApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServiceAdministratorApplication.class, args);
	}
}