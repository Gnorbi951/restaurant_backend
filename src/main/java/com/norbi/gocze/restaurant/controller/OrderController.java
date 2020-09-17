package com.norbi.gocze.restaurant.controller;

import com.norbi.gocze.restaurant.entity.Menu;
import com.norbi.gocze.restaurant.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final MenuService menuService;

    @GetMapping("/all")
    public List<Menu> getMenu() {
        return menuService.getAll();
    }
}
