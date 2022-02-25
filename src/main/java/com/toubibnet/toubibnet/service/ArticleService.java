package com.toubibnet.toubibnet.service;

import com.toubibnet.toubibnet.model.Article;
import com.toubibnet.toubibnet.model.Category;
import com.toubibnet.toubibnet.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository repository;

    public List<Article> getAll()
    {
        System.out.println("trying to find all");
        repository.findAll().forEach(
                (article)-> System.out.println(article)
        );
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
        article.setDate(new Date());
        return repository.save(article);
    }


    public List<Article> getByCategory(Category category)
    {
        return repository.findAllByCategory(category);
    }

    public List<Article> getByDoctor(@PathVariable long id)
    {
        return repository.findAllByDoctor_id(id);
    }
    public void deleteArticleById(long id)
    {
        System.out.println("Article deleted::"+id);
        repository.deleteById(id);
    }
    public List<Article> getByDoctorByKeyword(long id,String keyword)
    {
        return repository.findByDoctorByKeyword(id,keyword);
    }
}
