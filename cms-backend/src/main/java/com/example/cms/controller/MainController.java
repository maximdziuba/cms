package com.example.cms.controller;

import com.example.cms.model.Page;
import com.example.cms.model.PageElement;
import com.example.cms.service.PageElementService;
import com.example.cms.service.PageService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/pages")
@SecurityRequirement(name = "Bearer Authentication")
public class MainController {

    private final PageElementService pageElementService;
    private final PageService pageService;

    @GetMapping("/all")
    public List<Page> findAllElements() {
        return pageService.findAll();
    }

    @GetMapping("/{pageName}")
    public Page findElementById(@PathVariable(name = "pageName") String pageName) {
        System.out.println(pageName);
        return pageService.findByName(pageName);
    }
}
