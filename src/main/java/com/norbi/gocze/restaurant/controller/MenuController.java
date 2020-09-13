package com.norbi.gocze.restaurant.controller;

import com.norbi.gocze.restaurant.entity.Menu;
import com.norbi.gocze.restaurant.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/all")
    public List<Menu> getMenu() {
        return menuService.getAll();
    }

    @GetMapping("/get-by-category/{id}")
    public List<Menu> getMenuWhereCategoryMatches(@PathVariable("id") Long id) {
        return menuService.getItemsWhereIdMatches(id);
    }
}
