package com.norbi.gocze.restaurant.service;

import com.norbi.gocze.restaurant.entity.Category;
import com.norbi.gocze.restaurant.entity.Menu;
import com.norbi.gocze.restaurant.repository.CategoryRepository;
import com.norbi.gocze.restaurant.repository.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
@AllArgsConstructor
public class DataInitializer {

    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    public void fillDataBase() {
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
        chicken.setMenu(Collections.singletonList(friedChicken));

        categoryRepository.saveAll(Arrays.asList(pork, chicken)); // Important note: save category first

        menuRepository.saveAll(Arrays.asList(cordonBleu, friedSteak, friedChicken));
    }
}
