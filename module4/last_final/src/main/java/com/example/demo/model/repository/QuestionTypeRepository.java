package com.example.demo.model.repository;

import com.example.demo.model.entity.QuestionType;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface QuestionTypeRepository extends PagingAndSortingRepository<QuestionType, Long> {
}
