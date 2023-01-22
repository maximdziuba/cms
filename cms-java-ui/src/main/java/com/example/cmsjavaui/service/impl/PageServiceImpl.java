package com.example.cmsjavaui.service.impl;

import com.example.cmsjavaui.model.Page;
import com.example.cmsjavaui.repository.PageRepository;
import com.example.cmsjavaui.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {

    private final PageRepository pageRepository;


    @Override
    public List<Page> findAllPages() {
        return pageRepository.findAll();
    }

    @Override
    public Page findPageByName(String name) {
        return pageRepository.findByName(name).orElseThrow();
    }

    @Override
    public Page findPageById(Long id) {
        return pageRepository.findById(id).orElseThrow();
    }

    @Override
    public void savePage(Page page) {
        pageRepository.save(page);
    }
}
