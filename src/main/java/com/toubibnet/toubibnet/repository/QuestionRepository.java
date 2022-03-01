package com.toubibnet.toubibnet.repository;

import com.toubibnet.toubibnet.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    public List<Question> findByCategory(String category);
}
