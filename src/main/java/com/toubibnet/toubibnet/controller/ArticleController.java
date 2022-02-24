package com.toubibnet.toubibnet.controller;


import com.toubibnet.toubibnet.model.Article;
import com.toubibnet.toubibnet.model.Category;
import com.toubibnet.toubibnet.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService service;



    public ArticleController() {

    }

    @GetMapping("/")
    public List<Article> getAll()
    {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Article> getById(@PathVariable long id)
    {
        return  service.getById(id);
    }
    @GetMapping("/keyword/{keyword}")
    public List<Article> getByKeyword(@PathVariable String keyword)
    {
        System.out.println(keyword);
        return service.getByKeyword(keyword);
    }
    @PostMapping("/")
    public Article insertArticle(Article article)
    {
        return service.insertArticle(article);
    }

    @GetMapping("/category/{category}")
    public List<Article> getByCategory(@PathVariable Category category)
    {
        return service.getByCategory(category);
    }

}
