package com.practice_3_add_product_to_cart.model.service;

import com.practice_3_add_product_to_cart.model.entity.Product;
import com.practice_3_add_product_to_cart.model.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProduct{

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
