package com.norbi.gocze.restaurant.service;

import com.norbi.gocze.restaurant.entity.Menu;
import com.norbi.gocze.restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;

    public List<Menu> getAll() {
        return menuRepository.findAll();
    }
}
