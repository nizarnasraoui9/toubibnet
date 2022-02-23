package com.toubibnet.toubibnet.controller;

import com.toubibnet.toubibnet.model.Answer;
import com.toubibnet.toubibnet.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/answer")
@RestController
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @GetMapping
    public List<Answer> findAll() {
        return answerService.findAll();
    }

    @GetMapping("/id")
    public Answer findById(@RequestParam Long id) {
        return answerService.findById(id);
    }

    @PostMapping
    public Answer save(Answer answer) {
        return answerService.save(answer);
    }

    @PutMapping
    public Answer update(Answer answer) {
        return answerService.update(answer);
    }

    @DeleteMapping("/id")
    public boolean delete(@RequestParam Long id) {
        return answerService.delete(id);
    }

}
