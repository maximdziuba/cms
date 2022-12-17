package com.example.cms.service;

import com.example.cms.model.Page;
import com.example.cms.model.PageElement;

import java.util.List;

public interface PageService {

    List<Page> findAll();

    Page findById(Long id);

    Page findByName(String name);

    void save(Page page);

    void deleteById(Long id);
}
