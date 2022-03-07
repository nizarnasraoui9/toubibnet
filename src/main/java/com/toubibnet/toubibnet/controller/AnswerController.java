package com.toubibnet.toubibnet.controller;

import com.toubibnet.toubibnet.exception.ResourceNotFoundException;
import com.toubibnet.toubibnet.model.Answer;
import com.toubibnet.toubibnet.service.AnswerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/answer")
@RestController
public class AnswerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    AnswerService answerService;


    @GetMapping
    public List<Answer> findAll() {
        LOGGER.info("getAllAnswer");
        return answerService.findAll();
    }

    @GetMapping("/{id}")
    public Answer findById(@PathVariable Long id) throws ResourceNotFoundException {
        LOGGER.info("getAnswerById= " + id);
        return answerService.findById(id);
    }

    @GetMapping("/question/{id}")
    public List<Answer> findByQuestion(@PathVariable Long id){
        LOGGER.info("getAllAnswersForQuestionId= " + id);
        return answerService.findByQuestion(id);
    }
    @PostMapping("/question/{idQuestion}/doctor/{idDoctor}")
    public Answer save(@RequestBody Answer answer, @PathVariable Long idQuestion, @PathVariable Long idDoctor) throws ResourceNotFoundException {
        LOGGER.info("saveAnswerforQuestionId= " + idQuestion + " ByDoctorId=" + idDoctor + " AndAnswer=" + answer.toString());
        return answerService.save(answer, idQuestion, idDoctor);
    }

    @PutMapping
    public Answer update(@RequestBody Answer answer) throws ResourceNotFoundException {
        LOGGER.info("UpdateAnswer= " + answer.toString());
        return answerService.update(answer);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) throws ResourceNotFoundException {
        LOGGER.info("deleteAnswerById= " + id);
        return answerService.delete(id);
    }

}
