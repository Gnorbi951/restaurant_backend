package com.norbi.gocze.restaurant.service;

import com.norbi.gocze.restaurant.entity.Menu;
import com.norbi.gocze.restaurant.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public List<Menu> getAll() {
        return menuRepository.findAll();
    }
}
