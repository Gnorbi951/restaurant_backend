package com.norbi.gocze.restaurant.controller;

import com.norbi.gocze.restaurant.entity.Menu;
import com.norbi.gocze.restaurant.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public List<Menu> getMenuWhereCategoryMatches(@PathVariable("id") Long id) {
        System.out.println(id);
        return menuService.getItemsWhereIdMatcher(id);
    }
}
