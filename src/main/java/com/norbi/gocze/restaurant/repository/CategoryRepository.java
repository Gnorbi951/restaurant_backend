package com.norbi.gocze.restaurant.repository;

import com.norbi.gocze.restaurant.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT cat FROM Category cat WHERE cat.id = :id")
    Category getCategoryById(@Param("id") Long id);
}
