package model.service;

import model.bean.Product;

import java.util.List;

public interface IProduct {
    List<Product> findByAll();

    Product findById(String id);

    void edit(String id, Product product);

    void add(Product product);

    void remove(String id);
}
