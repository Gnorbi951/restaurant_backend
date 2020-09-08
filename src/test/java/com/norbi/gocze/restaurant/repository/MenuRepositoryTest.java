package com.norbi.gocze.restaurant.repository;

import com.norbi.gocze.restaurant.entity.Menu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class MenuRepositoryTest {

    @Autowired private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private EntityManager entityManager;
    @Autowired
    private MenuRepository menuRepository;

    @Test
    void injectedComponentsAreNotNull(){
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(menuRepository).isNotNull();
    }

    @Test
    public void itemsAreInserted() {
        Menu menu1 = Menu.builder()
                .name("Test Item 1")
                .build();
        Menu menu2 = Menu.builder()
                .name("Test Item 2")
                .build();
        menuRepository.saveAll(Arrays.asList(menu1, menu2));

        assertThat(menuRepository.findAll().size()).isEqualTo(2);
    }

}