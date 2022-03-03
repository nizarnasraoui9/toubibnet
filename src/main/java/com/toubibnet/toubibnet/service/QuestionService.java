package com.toubibnet.toubibnet.service;

import com.toubibnet.toubibnet.exception.ResourceNotFoundException;
import com.toubibnet.toubibnet.model.Category;
import com.toubibnet.toubibnet.model.Question;
import com.toubibnet.toubibnet.model.User;
import com.toubibnet.toubibnet.repository.QuestionRepository;
import com.toubibnet.toubibnet.repository.UserRepository;
import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserRepository userRepository;

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question findById(Long id) throws ResourceNotFoundException {

            return questionRepository.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("Question not found for this id :: " + id));

    }
    public List<Question> findByCategory(Category category){
        return questionRepository.findByCategory(category);
    }
    public List<Question> findByWord(String mot){
        return questionRepository.findByWord(mot);
    }
    public List<String> findCategories(){
        return Arrays.stream(Category.values()).map(c->c.toString()).collect(Collectors.toList());
    }

    public Question save(Question question, Long id) throws ResourceNotFoundException {
        userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User not found for this id")
                );
        return questionRepository.save(question);
    }

    public Question update(Question question) {
        try {
            questionRepository.findById(question.getId());
            return questionRepository.save(question);
        } catch (NullPointerException ex) {
            System.err.println("Question Not Found for this is " + question.getId());
            return new Question();
        }
    }

    public boolean deleteById(Long id) {
        try {
             questionRepository.deleteById(id);
             return true;
        } catch (NullPointerException n) {
            System.err.println("Question Not Found For this" + id);
            return false;
        }
    }

}
