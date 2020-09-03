package com.norbi.gocze.restaurant;

import com.norbi.gocze.restaurant.entity.Menu;
import com.norbi.gocze.restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestaurantBackendApplication {

    @Autowired
    MenuRepository menuRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            Menu testItem = Menu.builder().title("Test item").build();

            menuRepository.save(testItem);
        };

    }

}
