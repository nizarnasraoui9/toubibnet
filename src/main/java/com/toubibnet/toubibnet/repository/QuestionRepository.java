package com.toubibnet.toubibnet.repository;

import com.toubibnet.toubibnet.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query("select q from Question q where q.title LIKE %:mot% or q.content like %:mot%")
    List<Question> findByWord(String mot);
}
