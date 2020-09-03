package com.norbi.gocze.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Menu {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Long price;
    @ManyToOne
    private Category category;
    private String picture;
}
