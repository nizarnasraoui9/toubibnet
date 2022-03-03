package com.toubibnet.toubibnet.service;

import com.toubibnet.toubibnet.exception.ResourceNotFoundException;
import com.toubibnet.toubibnet.model.Answer;
import com.toubibnet.toubibnet.model.Doctor;
import com.toubibnet.toubibnet.model.Question;
import com.toubibnet.toubibnet.model.User;
import com.toubibnet.toubibnet.repository.AnswerRepository;
import com.toubibnet.toubibnet.repository.DoctorRepo;
import com.toubibnet.toubibnet.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    DoctorRepo doctorRepo;

    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    public Answer findById(Long id) throws ResourceNotFoundException {
        return answerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Answer not found for this id :: " + id));

    }
    public List<Answer> findByQuestion(Long id) {
        return answerRepository.findByQuestion(id);
    }


    public Answer save(Answer answer, Long idQuestion, Long idDoctor) throws ResourceNotFoundException {
       Question question =  questionRepository.findById(idQuestion).orElseThrow(() ->
                new ResourceNotFoundException("Question not found for this id :: " + idQuestion));
       Doctor doctor =  doctorRepo.findById(idDoctor).orElseThrow(() ->
                new ResourceNotFoundException("Question not found for this id :: " + idDoctor));
        answer.setDoctor(doctor);
        answer.setQuestion(question);
        return answerRepository.save(answer);
    }

    public Answer update(Answer answer) throws ResourceNotFoundException {
       Answer answer1 = answerRepository.findById(answer.getId()).orElseThrow(()
               -> new ResourceNotFoundException("Answer not Found for this id " + answer.getId() ));
        answer.setDoctor(answer1.getDoctor());
        answer.setQuestion(answer1.getQuestion());
        return answerRepository.save(answer);
    }

    public boolean delete(Long id) throws ResourceNotFoundException {
        Answer answer = answerRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Answer not Found for this id " + id ));
        answerRepository.delete(answer);
        return true;
    }
}
