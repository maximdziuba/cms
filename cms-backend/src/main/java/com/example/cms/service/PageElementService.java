package com.example.cms.service;

import com.example.cms.model.PageElement;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PageElementService{


    List<PageElement> findAll();

    PageElement findById(Long id);

    PageElement findByName(String name);

    void save(PageElement pageElement);

    void deleteById(Long id);
}
