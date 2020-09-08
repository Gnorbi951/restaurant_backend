package com.norbi.gocze.restaurant;


import com.norbi.gocze.restaurant.service.DataInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;


@SpringBootApplication
public class RestaurantBackendApplication {

    private final DataInitializer dataInitializer;

    public RestaurantBackendApplication(DataInitializer dataInitializer) {
        this.dataInitializer = dataInitializer;
    }

    public static void main(String[] args) {
        SpringApplication.run(RestaurantBackendApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            dataInitializer.fillDataBase();
        };

    }

}
