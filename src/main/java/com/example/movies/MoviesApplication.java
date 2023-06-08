package com.example.movies;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class MoviesApplication {
	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}
}

@Component
class ServerAddressConfigurator implements ApplicationListener<ApplicationReadyEvent> {

    @Value("${server.address}")
    private String serverAddress;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.setProperty("server.address", serverAddress);
        System.out.println("Server is listening on address: " + serverAddress);
    }
}