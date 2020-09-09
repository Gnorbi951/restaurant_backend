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

        Menu cordonBleu = Menu.builder().name("Cordon Bleu with Fries")
                .picture("https://i.imgur.com/Z8fHDAH.jpeg")
                .price(2300L)
                .category(pork)
                .build();
        Menu friedSteak = Menu.builder().name("Fried Steak with Mashed Potatoes")
                .picture("https://i.imgur.com/PLGTpqo.jpg")
                .price(2500L)
                .category(pork)
                .build();
        Menu newOrleansPork = Menu.builder().name("New Orleans Pork and Charred Beans")
                .picture("https://i.imgur.com/kywAM4n.jpg")
                .price(3200L)
                .category(pork)
                .build();
        Menu sriracha = Menu.builder().name("Sriracha Meatball Hoagies")
                .picture("https://i.imgur.com/DulU26k.jpg")
                .price(2350L)
                .category(pork)
                .build();
        Menu dijon = Menu.builder().name("Dijon Pork and Asparagus Sauté")
                .picture("https://i.imgur.com/EWyPGk5.jpg")
                .price(3600L)
                .category(pork)
                .build();
        Menu vietnamese_noodle_salad = Menu.builder().name("Vietnamese Noodle Salad")
                .picture("https://i.imgur.com/EWyPGk5.jpg")
                .price(1800L)
                .category(pork)
                .build();
        Menu grilledPork = Menu.builder().name("Grilled Pork Scaloppine with Mango Salsa")
                .picture("https://i.imgur.com/EWyPGk5.jpg")
                .price(2780L)
                .category(pork)
                .build();


        Menu friedChicken = Menu.builder().name("Fried Chicken")
                .picture("https://i.imgur.com/zXZvyga.jpeg")
                .price(1800L)
                .category(chicken)
                .build();

        pork.setMenu(Arrays.asList(cordonBleu, friedSteak, newOrleansPork, sriracha, dijon,
                                    vietnamese_noodle_salad, grilledPork));

        chicken.setMenu(Collections.singletonList(friedChicken));

        categoryRepository.saveAll(Arrays.asList(pork, chicken)); // Important note: save category first

        menuRepository.saveAll(Arrays.asList(cordonBleu, friedSteak, friedChicken, newOrleansPork,
                                            sriracha, dijon, vietnamese_noodle_salad, grilledPork));
    }
}
