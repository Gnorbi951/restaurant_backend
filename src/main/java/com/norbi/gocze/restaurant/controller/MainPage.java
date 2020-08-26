package com.norbi.gocze.restaurant.controller;

import com.norbi.gocze.restaurant.entity.Menu;
import com.norbi.gocze.restaurant.repository.MenuRepository;
import com.norbi.gocze.restaurant.service.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://random-takeaway.netlify.app"})
public class MainPage {

    @Autowired
    MenuRepository menuRepository;

    @GetMapping("/test")
    public ResponseObject getBasicMessage() {
        System.out.println("Request in");
        return ResponseObject.builder()
                .message("This is the test string")
                .build();
    }

    @GetMapping("/testmenu")
    public List<Menu> getMenu() {
        return menuRepository.findAll();
    }

}
