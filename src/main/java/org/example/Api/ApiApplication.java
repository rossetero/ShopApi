package org.example.Api;

import org.example.Api.models.Address;
import org.example.Api.models.Supplier;
import org.example.Api.repositories.AddressRepository;
//import org.example.Api.repositories.AddressRepositoryImpl;
import org.example.Api.repositories.AddressRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.UUID;

@SpringBootApplication
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
