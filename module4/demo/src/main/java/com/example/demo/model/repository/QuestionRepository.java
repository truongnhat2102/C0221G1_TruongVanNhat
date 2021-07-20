package com.example.demo.model.repository;

import com.example.demo.model.entity.Question;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {
}
