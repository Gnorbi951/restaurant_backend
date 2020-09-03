package com.norbi.gocze.restaurant;

import com.norbi.gocze.restaurant.entity.Category;
import com.norbi.gocze.restaurant.entity.Menu;
import com.norbi.gocze.restaurant.repository.CategoryRepository;
import com.norbi.gocze.restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class RestaurantBackendApplication {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            Category pork = Category.builder().name("Pork").build();
            Category chicken = Category.builder().name("Chicken").build();

            Menu cordonBleu = Menu.builder().name("Cordon Bleu")
                    .picture("https://i.imgur.com/Z8fHDAH.jpg")
                    .price(2300L)
                    .category(pork)
                    .build();
            Menu friedSteak = Menu.builder().name("Fried Steak")
                    .picture("https://i.imgur.com/HJsnNnS.jpg")
                    .price(2500L)
                    .category(pork)
                    .build();

            Menu friedChicken = Menu.builder().name("Fried Chicken")
                    .picture("https://i.imgur.com/zXZvyga.jpeg")
                    .price(1800L)
                    .category(chicken)
                    .build();

            pork.setMenu(Arrays.asList(cordonBleu, friedSteak));

            categoryRepository.saveAll(Arrays.asList(pork, chicken)); // Important note: save category first

            menuRepository.saveAll(Arrays.asList(cordonBleu, friedSteak, friedChicken));
        };

    }

}
