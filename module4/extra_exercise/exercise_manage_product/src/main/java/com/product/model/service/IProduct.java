package com.product.model.service;

import com.product.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProduct<T> {
    Page<T> findAll(Pageable pageable);

    List<T> findAll();

    <T> T findById(long id);

//    Page<T> findByName(Pageable pageable, String search);

    public void save(T t);
    public void remove(long id);
}
