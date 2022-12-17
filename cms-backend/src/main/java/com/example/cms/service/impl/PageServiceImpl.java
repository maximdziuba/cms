package com.example.cms.service.impl;

import com.example.cms.model.Page;
import com.example.cms.repository.PageRepository;
import com.example.cms.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {

    private final PageRepository pageRepository;

    @Override
    public List<Page> findAll() {
        return pageRepository.findAll();
    }

    @Override
    public Page findById(Long id) {
        return pageRepository.findById(id).orElseThrow();
    }

    @Override
    public Page findByName(String name) {
        return pageRepository.findPageByName(name).orElseThrow();
    }

    @Override
    public void save(Page page) {
        pageRepository.save(page);
    }

    @Override
    public void deleteById(Long id) {
        pageRepository.deleteById(id);
    }
}
