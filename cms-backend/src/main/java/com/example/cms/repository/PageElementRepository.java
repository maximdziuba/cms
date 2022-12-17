package com.example.cms.repository;

import com.example.cms.model.PageElement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageElementRepository extends JpaRepository<PageElement, Long> {
    PageElement findPageElementByName(String name);
}
