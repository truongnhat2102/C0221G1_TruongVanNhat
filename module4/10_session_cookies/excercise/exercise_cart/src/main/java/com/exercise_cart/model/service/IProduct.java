package com.exercise_cart.model.service;

import com.exercise_cart.model.entity.Product;

import java.util.List;

public interface IProduct {
    List<Product> findAll();
    Product findById(Long id);
}
