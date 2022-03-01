package com.toubibnet.toubibnet.service;

import com.toubibnet.toubibnet.model.Category;
import com.toubibnet.toubibnet.model.Question;
import com.toubibnet.toubibnet.model.User;
import com.toubibnet.toubibnet.repository.QuestionRepository;
import com.toubibnet.toubibnet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserRepository userRepository;

    public List<Question> findAll() {
        System.out.println(questionRepository.findAll());
        return questionRepository.findAll();
    }

    public Question findById(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        if (!question.isPresent()) {
            return new Question();
        }
        return question.get();
    }
    public List<Question> findByCategory(String category){
        return questionRepository.findByCategory(category);
    }
    public List<Question> findByWord(String mot){
        return questionRepository.findByWord(mot);
    }
    public List<String> findCategories(){
        return Arrays.stream(Category.values()).map(c->c.toString()).collect(Collectors.toList());
    }

    public Question save(Question question, Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            question.setUser(new User());
        } else {
            question.setUser(user.get());
        }
        return questionRepository.save(question);
    }

    public Question update(Question question) {
        Optional<Question> question1 = questionRepository.findById(question.getId());
        if (!question1.isPresent()) {
            return new Question();
        }
        return questionRepository.save(question);
    }

    public boolean deleteById(Long id) {
        Optional<Question> question1 = questionRepository.findById(id);
        if (!question1.isPresent()) {
            return false;
        }
        questionRepository.deleteById(id);
        return true;
    }

}
