package com.example.cms;

import com.example.cms.repository.PageRepository;
import com.example.cms.service.PageElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class CmsApplication {

    private final PageElementService pageElementService;
    private final PageRepository pageRepository;

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }

    @PostConstruct
    private void init() {
        /*
        Page page = new Page();
        PageElement pageElement1 = new PageElement("loginPageTitle", "Login Page From Backend");
        PageElement pageElement2 = new PageElement("logo", "Company");
        List<PageElement> pageElements = new ArrayList<>();
        pageElementService.save(pageElement1);
        pageElementService.save(pageElement2);
        pageElements.add(pageElement1);
        pageElements.add(pageElement2);
        page.setName("loginPage");
        page.setPageElements(pageElements);
        pageRepository.save(page);
         */
//        Page pageFromDb = pageRepository.findById(2L).orElseThrow();
    }
}
