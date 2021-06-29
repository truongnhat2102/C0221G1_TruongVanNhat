package com.practice_3_add_product_to_cart.model.service;

import com.practice_3_add_product_to_cart.model.entity.Product;

import java.util.List;

public interface IProduct {
    List<Product> findAll();
    Product findById(Long id);
}
