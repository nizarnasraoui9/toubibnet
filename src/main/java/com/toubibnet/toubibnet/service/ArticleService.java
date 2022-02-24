package com.toubibnet.toubibnet.service;

import com.toubibnet.toubibnet.model.Article;
import com.toubibnet.toubibnet.model.Category;
import com.toubibnet.toubibnet.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository repository;

    public List<Article> getAll()
    {
        return repository.findAll();
    }

    public Optional<Article> getById(long id)  {
        return  repository.findById(id);
    }

    public List<Article> getByKeyword( String keyword)
    {
        System.out.println(keyword);
        return repository.findByKeyword(keyword);
    }

    public Article insertArticle(Article article)
    {
        return repository.save(article);
    }


    public List<Article> getByCategory(Category category)
    {
        return repository.findAllByCategory(category);
    }
}
