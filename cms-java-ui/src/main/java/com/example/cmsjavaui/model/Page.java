package com.example.cmsjavaui.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(targetEntity = PageElement.class, cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<PageElement> pageElements = new ArrayList<>();
}