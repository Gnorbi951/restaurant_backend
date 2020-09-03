package com.norbi.gocze.restaurant.repository;


import com.norbi.gocze.restaurant.entity.Category;
import com.norbi.gocze.restaurant.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long>{

    @Query(value = "select item from Menu item where :category = item.category ")
    List<Menu> getItemsWhereCategoryIdMatcher(@Param("category")Category category);
}
