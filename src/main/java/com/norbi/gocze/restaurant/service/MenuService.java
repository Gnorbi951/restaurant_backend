package com.norbi.gocze.restaurant.service;

import com.norbi.gocze.restaurant.entity.Category;
import com.norbi.gocze.restaurant.entity.Menu;
import com.norbi.gocze.restaurant.repository.CategoryRepository;
import com.norbi.gocze.restaurant.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    public List<Menu> getItemsWhereIdMatcher(Long id) {
        Category category = categoryRepository.getCategoryById(id);
        return menuRepository.findAllByCategory(category);
    }
}
