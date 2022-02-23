package com.toubibnet.toubibnet.service;

import com.toubibnet.toubibnet.model.Answer;
import com.toubibnet.toubibnet.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;

    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    public Answer findById(Long id) {
        Optional<Answer> answer = answerRepository.findById(id);
        if (!answer.isPresent()) {
            return new Answer();
        }
        return answer.get();
    }

    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    public Answer update(Answer answer) {
        Optional<Answer> answer1 = answerRepository.findById(answer.getId());
        if (!answer1.isPresent()) {
            return new Answer();
        }
        return answerRepository.saveAndFlush(answer);
    }

    public boolean delete(Long id) {
        answerRepository.deleteById(id);
        Optional<Answer> answer = answerRepository.findById(id);
        if (answer.isPresent()) {
            return false;
        }
        return true;
    }
}
