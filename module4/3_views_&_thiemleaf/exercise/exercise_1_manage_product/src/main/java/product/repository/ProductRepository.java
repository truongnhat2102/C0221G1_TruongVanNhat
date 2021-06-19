package product.repository;

import product.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1,"Samsung",100000));
        products.put(2, new Product(2,"iphone",100000));
        products.put(3, new Product(3,"nokia",100000));
    }

    public List<Product> findAll(){
        return new ArrayList<>(products.values());
    }

    public void save(Product product){
        products.put(product.getId(), product);
    }

    public Product findById(int id){
        return products.get(id);
    }

    public List<Product> findByName(String name){
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().contains(name)){
                productList.add(products.get(i));
            }
        }
        return productList;
    }

    public void update(int id, Product product){
        products.put(id, product);
    }

    public void remove(int id){
        products.remove(id);
    }
}
