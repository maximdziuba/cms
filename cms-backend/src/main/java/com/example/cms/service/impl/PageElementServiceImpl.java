package com.example.cms.service.impl;

import com.example.cms.model.PageElement;
import com.example.cms.repository.PageElementRepository;
import com.example.cms.service.PageElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PageElementServiceImpl implements PageElementService {

    private final PageElementRepository pageElementRepository;

    @Override
    public List<PageElement> findAll() {
        return pageElementRepository.findAll();
    }

    @Override
    public PageElement findById(Long id) {
        return pageElementRepository.findById(id).orElseThrow();
    }

    @Override
    public PageElement findByName(String name) {
        return pageElementRepository.findPageElementByName(name);
    }

    @Override
    public void save(PageElement pageElement) {
        pageElementRepository.save(pageElement);
    }

    @Override
    public void deleteById(Long id) {
        pageElementRepository.deleteById(id);
    }
}
