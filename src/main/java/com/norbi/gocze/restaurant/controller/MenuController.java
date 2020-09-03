package com.norbi.gocze.restaurant.controller;

import com.norbi.gocze.restaurant.entity.Menu;
import com.norbi.gocze.restaurant.repository.MenuRepository;
import com.norbi.gocze.restaurant.service.MenuService;
import com.norbi.gocze.restaurant.service.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = {"http://localhost:3000", "https://random-takeaway.netlify.app"})
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/all")
    public List<Menu> getMenu() {
        return menuService.getAll();
    }

}
