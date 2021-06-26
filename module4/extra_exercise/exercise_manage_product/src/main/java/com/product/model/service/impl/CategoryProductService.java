package com.product.model.service.impl;

import com.product.model.entity.CategoryProduct;
import com.product.model.repository.CategoryProductRepository;
import com.product.model.service.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryProductService implements IProduct {

    @Autowired
    CategoryProductRepository categoryProductRepository;

    @Override
    public Page findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<CategoryProduct> findAll() {
        return (List<CategoryProduct>) categoryProductRepository.findAll();
    }

    @Override
    public void save(Object o) {
        categoryProductRepository.save((CategoryProduct) o);
    }

    @Override
    public void remove(long id) {
        categoryProductRepository.deleteById(id);
    }

    @Override
    public CategoryProduct findById(long id) {
        return categoryProductRepository.findById(id).orElse(null);
    }
}
