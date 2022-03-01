package com.toubibnet.toubibnet.repository;

import com.toubibnet.toubibnet.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByCategory(String category);

    @Query("select q from Question q where q.content LIKE %:mot% or q.title LIKE %:mot%")
    List <Question> findByWord(@Param("mot")String mot);
}
