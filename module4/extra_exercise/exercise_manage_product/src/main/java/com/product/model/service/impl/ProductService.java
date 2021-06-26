package com.product.model.service.impl;

import com.product.model.entity.Product;
import com.product.model.repository.ProductRepository;
import com.product.model.service.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProduct {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List findAll() {
        return null;
    }

//    @Override
//    public Page<Product> findByName(Pageable pageable, String search) {
//       Page<Product> products = null;
//        for (long i = 0; i < findAll(pageable).getSize(); i++) {
//            if (findById(i).getNameProduct().contains(search)){
//                products.(findById(i));
//            }
//        }
//    }

    @Override
    public void save(Object o) {
        productRepository.save((Product) o);
    }

    @Override
    public void remove(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElse(null);
    }
}
