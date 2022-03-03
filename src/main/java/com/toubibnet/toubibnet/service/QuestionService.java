package com.toubibnet.toubibnet.service;

import com.toubibnet.toubibnet.dto.QuestionPerPageDto;
import com.toubibnet.toubibnet.exception.ResourceNotFoundException;
import com.toubibnet.toubibnet.model.Category;
import com.toubibnet.toubibnet.model.Question;
import com.toubibnet.toubibnet.repository.QuestionRepository;
import com.toubibnet.toubibnet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    QuestionPerPageDto questionPerPageDto = new QuestionPerPageDto();


    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public QuestionPerPageDto findAllPerPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Question> questionPage = questionRepository.findBy(pageable);
        questionPerPageDto.setQuestion(questionPage.getContent());
        questionPerPageDto.setTotal(questionPage.getTotalElements());
        return questionPerPageDto;
    }


    public Question findById(Long id) throws ResourceNotFoundException {

        return questionRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Question not found for this id :: " + id));

    }

    public List<Question> findByCategory(Category category) {
        return questionRepository.findByCategory(category);
    }

    public QuestionPerPageDto findByCategoryPerPage(Category category, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Question> pageOfQuestion = questionRepository.findByCategory(category, pageable);
        questionPerPageDto.setQuestion(pageOfQuestion.getContent());
        questionPerPageDto.setTotal(pageOfQuestion.getTotalElements());
        return questionPerPageDto;
    }


    public List<Question> findByWord(String mot) {
        return questionRepository.findByWord(mot);
    }

    public QuestionPerPageDto findByWordPerPage(String mot, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Question> pageOfQuestion = questionRepository.findByWord(mot, pageable);
        questionPerPageDto.setQuestion(pageOfQuestion.getContent());
        questionPerPageDto.setTotal(pageOfQuestion.getTotalElements());
        return questionPerPageDto;
    }


    public List<String> findCategories() {
        return Arrays.stream(Category.values()).map(c -> c.toString()).collect(Collectors.toList());
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
