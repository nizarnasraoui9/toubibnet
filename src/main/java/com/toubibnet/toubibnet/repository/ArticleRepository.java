package com.toubibnet.toubibnet.repository;

import com.toubibnet.toubibnet.model.Article;
import com.toubibnet.toubibnet.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query(value = "SELECT a from Article a WHERE a.title LIKE %:keyword% OR a.description LIKE %:keyword%" )
    List<Article> findByKeyword(@Param(value = "keyword") String keyword);
    List<Article> findAllByCategory(Category category);
    List<Article> findAllByDoctor_id(long id);
    @Query(value = "SELECT a from Article a WHERE (a.title LIKE %:keyword% OR a.description LIKE %:keyword%) AND a.doctor.id=:id" )
    List<Article> findByDoctorByKeyword(@Param("id") long id ,@Param("keyword") String keyword);
}