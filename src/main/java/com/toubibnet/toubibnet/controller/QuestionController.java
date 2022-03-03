package com.toubibnet.toubibnet.controller;

import com.toubibnet.toubibnet.dto.QuestionPerPageDto;
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
        LOGGER.info("getAllQuestion");
        return questionService.findAll();
    }

    @GetMapping(value = "/page/{page}/{size}")
    public QuestionPerPageDto findAllPerPage(@PathVariable(value = "page") Integer page,
                                             @PathVariable(value = "size") Integer size) {
        LOGGER.info("getAllQuestion");
        return questionService.findAllPerPage(page, size);
    }

  /*  @GetMapping(value = "/totalelements/{page}/{size}")
    public Long findNumberOfTotalElement(@PathVariable(value = "page") Integer page,
                                         @PathVariable(value = "size") Integer size) {
        LOGGER.info("getAllQuestion");
        return questionService.findNumberOfTotalElement(page, size);
    }
*/
    @GetMapping("/{id}")
    public Question findById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        LOGGER.info("getQuestionByid/" + id);
        return questionService.findById(id);
    }

    @GetMapping("/category/{category}")
    public List<Question> findByCategory(@PathVariable(value = "category") Category category) {
        LOGGER.info("getQuestionByCategory/" + category);
        return questionService.findByCategory(category);
    }

    @GetMapping("/category/{category}/page/{page}/{size}")
    public QuestionPerPageDto findByCategoryPerPage(@PathVariable(value = "category") Category category,
                                                @PathVariable(value = "page") Integer page,
                                                @PathVariable(value = "size") Integer size) {
        LOGGER.info("getQuestionByCategory/" + category);
        return questionService.findByCategoryPerPage(category, page, size);
    }

   /* @GetMapping("/totalelementsbycategory/{category}/page/{page}/{size}")
    public Long findNumberOfTotalElementByCategory(@PathVariable(value = "category") Category category,
                                                   @PathVariable(value = "page") Integer page,
                                                   @PathVariable(value = "size") Integer size) {
        LOGGER.info("getQuestionByCategory/" + category);
        return questionService.findNumberOfTotalElementByCategory(category, page, size);
    }
*/
    @GetMapping("/search/{mot}")
    public List<Question> findByWord(@PathVariable(value = "mot") String mot) {
        LOGGER.info("getQuestionByWord/" + mot);
        return questionService.findByWord(mot);
    }

    @GetMapping("/search/{mot}/page/{size}/{page}")
    public QuestionPerPageDto findByWordPerPage(@PathVariable(value = "mot") String mot,
                                            @PathVariable(value = "page") Integer page,
                                            @PathVariable(value = "size") Integer size) {
        LOGGER.info("getQuestionByWord/" + mot);
        return questionService.findByWordPerPage(mot, page, size);
    }

   /* @GetMapping("/totalelementsbyword/{mot}/page/{size}/{page}")
    public Long findNumberOfElementByWord(@PathVariable(value = "mot") String mot,
                                          @PathVariable(value = "page") Integer page,
                                          @PathVariable(value = "size") Integer size) {
        LOGGER.info("getQuestionByWord/" + mot);
        return questionService.findNumberOfElementByWord(mot, page, size);
    }
*/
    @GetMapping("/categories")
    public List<String> findByCategories() {
        return questionService.findCategories();
    }

    @PostMapping("/{id}")
    public Question save(@PathVariable(value = "id") Long id, @RequestBody Question question) throws ResourceNotFoundException {
        LOGGER.info("saveQuestionByUser/" + id + " andquetionId= " + question.getId());
        return questionService.save(question, id);
    }

    @PutMapping
    public Question update(@RequestBody Question question) {
        LOGGER.info("updateQuestion= " + question.getId());
        return questionService.update(question);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable(value = "id") Long id) {
        LOGGER.info("deleteQuestionById= " + id);
        return questionService.deleteById(id);
    }


}
