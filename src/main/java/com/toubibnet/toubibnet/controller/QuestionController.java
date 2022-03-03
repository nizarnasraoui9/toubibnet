package com.toubibnet.toubibnet.controller;

import com.toubibnet.toubibnet.exception.ResourceNotFoundException;
import com.toubibnet.toubibnet.model.Category;
import com.toubibnet.toubibnet.model.Question;
import com.toubibnet.toubibnet.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/question")
public class QuestionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    QuestionService questionService;

    @GetMapping
    public List<Question> findAll() {
        LOGGER.info("getAll");
        return questionService.findAll();
    }

    @GetMapping("/{id}")
    public Question findById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return questionService.findById(id);

    }

    @GetMapping("/category/{category}")
    public List<Question> findByCategory(@PathVariable(value = "category") Category category) {
        return questionService.findByCategory(category);

    }
    @GetMapping("/search/{mot}")
    public List<Question> findByWord(@PathVariable(value = "mot") String mot) {
        return questionService.findByWord(mot);

    }
    @GetMapping("/categories")
    public List<String> findByCategories() {
        return questionService.findCategories();

    }

    @PostMapping("/{id}")
    public Question save(@PathVariable(value = "id") Long id, @RequestBody Question question) throws ResourceNotFoundException {
        return questionService.save(question, id);
    }

    @PutMapping
    public Question update(@RequestBody Question question) {
        return questionService.update(question);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable(value = "id") Long id) {
        return questionService.deleteById(id);
    }


}
