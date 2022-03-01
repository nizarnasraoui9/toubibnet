package com.toubibnet.toubibnet.controller;

import com.toubibnet.toubibnet.model.Question;
import com.toubibnet.toubibnet.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping
    public List<Question> findAll() {
        return questionService.findAll();
    }

    @GetMapping("/{id}")
    public Question findById(@PathVariable(value = "id") Long id) {
        return questionService.findById(id);

    }

    @GetMapping("/category/{category}")
    public List<Question> findByCategory(@PathVariable(value = "category") String category) {
        return questionService.findByCategory(category);

    }
    @GetMapping("/search/{mot}")
    public List<Question> findByWord(@PathVariable(value = "mot") String mot) {
        return questionService.findByCategory(mot);

    }

    @PostMapping("/{id}")
    public Question save(@PathVariable(value = "id") Long id, @RequestBody Question question) {
        return questionService.save(question, id);
    }

    @PutMapping
    public Question update(@RequestBody Question question) {
        return questionService.update(question);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable(value = "id") Long id) {
        System.err.println(id + " saif");
        return questionService.deleteById(id);
    }

}
