package com.exercise_2_manage_phone.model.repository;

import com.exercise_2_manage_phone.model.entity.SmartPhone;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartPhoneRepository extends PagingAndSortingRepository<SmartPhone, Long> {
}
