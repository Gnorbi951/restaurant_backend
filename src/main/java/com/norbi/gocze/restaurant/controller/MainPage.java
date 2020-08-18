package com.norbi.gocze.restaurant.controller;

import com.norbi.gocze.restaurant.service.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://dazzling-goldwasser-51c6a3.netlify.app"})
public class MainPage {


    @GetMapping("/test")
    public ResponseObject getBasicMessage() {
        System.out.println("Request in");
        return ResponseObject.builder()
                .message("This is the test string")
                .build();
    }

}
