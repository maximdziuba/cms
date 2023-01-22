package com.example.cmsjavaui.service;

import com.example.cmsjavaui.model.Page;

import java.util.List;

public interface PageService {

    List<Page> findAllPages();

    Page findPageByName(String name);

    Page findPageById(Long id);

    void savePage(Page page);
}
