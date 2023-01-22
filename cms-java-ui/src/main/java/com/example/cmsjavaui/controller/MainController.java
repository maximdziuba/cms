package com.example.cmsjavaui.controller;

import com.example.cmsjavaui.model.Page;
import com.example.cmsjavaui.model.PageElement;
import com.example.cmsjavaui.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final PageService pageService;

    @GetMapping("/")
    public String home(Model model) {
        List<Page> allPages = pageService.findAllPages();
        model.addAttribute("pages", allPages);
        return "home";
    }

    @PostMapping("/{pageId}/{pageElementName}")
    public String changePageElementText(@PathVariable(name = "pageId") Long pageId,
                                        @PathVariable(name = "pageElementName") String pageElementName,
                                        @RequestParam(name = "newPageElementText") String newPageElementText) {
        Page pageFromDb = pageService.findPageById(pageId);
        PageElement element = pageFromDb.getPageElements().stream().filter(pageElement -> pageElement.getName().equals(pageElementName)).findFirst().orElseThrow();
        System.out.println(element);
        element.setText(newPageElementText);
        pageService.savePage(pageFromDb);
        System.out.println(element);
        return "redirect:/";
    }
}
