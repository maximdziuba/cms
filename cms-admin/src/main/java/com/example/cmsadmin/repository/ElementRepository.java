package com.example.cmsadmin.repository;

import com.example.cmsadmin.model.PageElement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<PageElement, Long> {
}
