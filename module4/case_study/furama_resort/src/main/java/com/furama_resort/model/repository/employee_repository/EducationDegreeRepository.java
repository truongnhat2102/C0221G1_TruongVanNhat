package com.furama_resort.model.repository.employee_repository;

import com.furama_resort.model.entity.employee.EducationDegree;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationDegreeRepository extends PagingAndSortingRepository<EducationDegree, Long> {
}
