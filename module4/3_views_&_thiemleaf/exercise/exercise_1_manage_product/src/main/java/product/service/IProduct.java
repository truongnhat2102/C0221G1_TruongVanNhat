package product.service;

import product.model.Product;

import java.util.List;

public interface IProduct {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    List<Product> findByName(String name);

    void update(int id, Product product);

    void remove(int id);
}
