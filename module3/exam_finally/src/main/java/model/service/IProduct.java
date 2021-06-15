package model.service;

import model.bean.Product;

import java.util.List;

public interface IProduct {
    List<Product> findByAll();
    Product findById(int id);
    String[] add(Product product);
    String[] edit(Product product);
    boolean delete(int id);
}
