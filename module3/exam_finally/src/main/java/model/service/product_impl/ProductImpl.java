package model.service.product_impl;

import model.bean.Product;
import model.repository.ProductRepository;
import model.service.IProduct;

import java.util.List;

public class ProductImpl implements IProduct {
    ProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> findByAll() {
        return productRepository.findByAllProduct();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findByIdProduct(id);
    }

    @Override
    public String[] add(Product product) {
        boolean flag = true;
        String msgName = "";
        if ("".equals(product.getNameProduct())){
            msgName = "please input name";
            flag = false;
        }
        if (flag){
            flag = productRepository.add(product);
        }
        return flag? new String[]{} : new String[]{msgName};
    }

    @Override
    public String[] edit(Product product) {
        boolean flag = true;
        String msgName = "";
        if ("".equals(product.getNameProduct())){
            msgName = "please input name";
            flag = false;
        }
        if (flag){
            flag = productRepository.edit(product);
        }
        return flag? new String[]{} : new String[]{msgName};
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }
}
