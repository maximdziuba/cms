package com.example.cms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
//    @JoinTable(name = "page_element", joinColumns = @JoinColumn(name = "id"))
    private List<PageElement> pageElements = new ArrayList<>();
}
