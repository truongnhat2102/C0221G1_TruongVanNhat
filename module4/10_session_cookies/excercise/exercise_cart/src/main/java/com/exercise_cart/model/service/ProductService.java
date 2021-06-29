package com.exercise_cart.model.service;

import com.exercise_cart.model.entity.Product;
import com.exercise_cart.model.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProduct {

    @Autowired
    IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) iProductRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.findById(id).orElse(null);
    }
}
