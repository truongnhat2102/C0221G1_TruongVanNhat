package model.service.productImpliment;

import model.bean.Product;
import model.repository.ProductRepository;
import model.service.IProduct;

import java.util.List;

public class ProductImpl implements IProduct {
    ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findByAll() {
        return productRepository.findByAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void edit(String id, Product product) {
        productRepository.edit(id,product);
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void remove(String id) {
        productRepository.remove(id);
    }
}
