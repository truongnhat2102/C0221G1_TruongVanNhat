package com.example.demo.model.service.impl;

import com.example.demo.model.entity.Question;
import com.example.demo.model.entity.QuestionType;
import com.example.demo.model.repository.QuestionRepository;
import com.example.demo.model.repository.QuestionTypeRepository;
import com.example.demo.model.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Override
    public Page<Question> findAllQuestion(Pageable pageable) {
        return  this.questionRepository.findAll(pageable);
    }

    @Override
    public Question findQuestionById(long id) {
        return this.questionRepository.findById(id).orElse(null);
    }

    @Override
    public List<QuestionType> findAllQuestionType() {
        return (List<QuestionType>) this.questionTypeRepository.findAll();
    }

    @Override
    public void save(Question question) {
        this.questionRepository.save(question);
    }

    @Override
    public void delete(long id) {
        this.questionRepository.deleteById(id);
    }
}
