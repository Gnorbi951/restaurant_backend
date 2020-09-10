package com.norbi.gocze.restaurant.repository;

import com.norbi.gocze.restaurant.entity.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("dev")
class CategoryRepositoryTest {

    @Autowired
    private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private EntityManager entityManager;
    @Autowired private CategoryRepository categoryRepository;

    @Test
    void injectedComponentsAreNotNull(){
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(categoryRepository).isNotNull();
    }

    @Test
    void categoryIsFoundById() {
        Category category = Category.builder()
                .name("Test Category")
                .build();
        // id can not be directly set (GeneratedValue)
        categoryRepository.save(category);

        List<Category> repo = categoryRepository.findAll();
        Long id = repo.get(0).getId();

        assertThat(categoryRepository.getCategoryById(id).getName()).isEqualTo("Test Category");
    }
}