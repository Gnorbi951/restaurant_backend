package com.norbi.gocze.restaurant.service;

import com.norbi.gocze.restaurant.entity.Category;
import com.norbi.gocze.restaurant.entity.Menu;
import com.norbi.gocze.restaurant.repository.CategoryRepository;
import com.norbi.gocze.restaurant.repository.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class DataInitializer {

    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    public void fillDataBase() {
        Category pork = Category.builder().name("Pork").build();
        Category chicken = Category.builder().name("Chicken").build();
        Category beef = Category.builder().name("Beef").build();

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
                .picture("https://i.imgur.com/HhgHuX3.jpg")
                .price(1800L)
                .category(chicken)
                .build();
        Menu fontina = Menu.builder().name("Fontina Rolled Chicken")
                .picture("https://i.imgur.com/FPGxTx1.jpg")
                .price(2100L)
                .category(chicken)
                .build();
        Menu alfredo = Menu.builder().name("Chicken-Pepper Alfredo")
                .picture("https://i.imgur.com/S6DwVuc.jpg")
                .price(1650L)
                .category(chicken)
                .build();
        Menu glazedChicken = Menu.builder().name("Teriyaki Glazed Chicken")
                .picture("https://i.imgur.com/02DzKsV.jpg")
                .price(2300L)
                .category(chicken)
                .build();
        Menu bbqChicken = Menu.builder().name("Barbecue Chicken Quesadillas")
                .picture("https://i.imgur.com/79LA79J.jpg")
                .price(2140L)
                .category(chicken)
                .build();
        Menu chickenSandwich = Menu.builder().name("Bacon & Swiss Chicken Sandwiches")
                .picture("https://i.imgur.com/up95lgu.jpg")
                .price(1900L)
                .category(chicken)
                .build();
        Menu ginger = Menu.builder().name("Ginger-Cashew Chicken Salad")
                .picture("https://i.imgur.com/IMYp9AA.jpg")
                .price(2200L)
                .category(chicken)
                .build();

        Menu beefCheddar = Menu.builder().name("Beef and Cheddar Casserole")
                .picture("https://i.imgur.com/1nOVlF2.jpg")
                .price(3300L)
                .category(beef)
                .build();
        Menu cowboyNachos = Menu.builder().name("Cowboy Nachos")
                .picture("https://i.imgur.com/MQ8TyJw.jpg")
                .price(3000L)
                .category(beef)
                .build();
        Menu potRoast = Menu.builder().name("Beef and Potatoes Pot Roast")
                .picture("https://i.imgur.com/ZZ0Ro4g.jpg")
                .price(3800L)
                .category(beef)
                .build();
        Menu teriyaki = Menu.builder().name("Teriyaki Beef Stir-Fry")
                .picture("https://i.imgur.com/yOCHTv2.jpg")
                .price(4200L)
                .category(beef)
                .build();
        Menu ribs = Menu.builder().name("Braised Beef Short Ribs")
                .picture("https://i.imgur.com/9cIDzq6.jpg")
                .price(4100L)
                .category(beef)
                .build();
        Menu brisket = Menu.builder().name("Smoked Beef Brisket")
                .picture("https://i.imgur.com/h7Qd3tB.jpg")
                .price(4100L)
                .category(beef)
                .build();
        Menu goulash = Menu.builder().name("Hungarian Goulash with Spaetzle")
                .picture("https://i.imgur.com/zBxIjey.jpg")
                .price(4450L)
                .category(beef)
                .build();
        Menu steak = Menu.builder().name("Ancho steak & chimichurri buttered sweetcorn")
                .picture("https://i.imgur.com/BROfUOu.jpg")
                .price(4700L)
                .category(beef)
                .build();








        pork.setMenu(Arrays.asList(cordonBleu, friedSteak, newOrleansPork, sriracha, dijon,
                                    vietnamese_noodle_salad, grilledPork));

        chicken.setMenu(Arrays.asList(friedChicken, fontina, alfredo, glazedChicken, bbqChicken,
                                      chickenSandwich, ginger));

        beef.setMenu(Arrays.asList(beefCheddar, cowboyNachos, potRoast, teriyaki, ribs, brisket,
                                   goulash, steak));

        categoryRepository.saveAll(Arrays.asList(pork, chicken, beef)); // Important note: save category first

        menuRepository.saveAll(Arrays.asList(cordonBleu, friedSteak, friedChicken, newOrleansPork,
                                            sriracha, dijon, vietnamese_noodle_salad, grilledPork,
                                            fontina, alfredo, glazedChicken, bbqChicken, chickenSandwich,
                                            ginger, beefCheddar, cowboyNachos, potRoast, teriyaki,
                                            ribs, brisket, goulash, steak));
    }
}
