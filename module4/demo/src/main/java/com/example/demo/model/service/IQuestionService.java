package com.example.demo.model.service;

import com.example.demo.model.entity.Question;
import com.example.demo.model.entity.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuestionService {
    Page<Question> findAllQuestion(Pageable pageable);

    Question findQuestionById(long id);

    List<QuestionType> findAllQuestionType();

    void save(Question question);

    void delete(long id);
}
