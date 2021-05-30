package model.repository;

import model.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    static Map<String, Product> map = new HashMap<>();

    static {
        map.put("1", new Product(1, "NOTE9", "1000", "smart phone", "samsung"));
        map.put("2", new Product(2, "NOTE10", "2000", "smart phone", "samsung"));
        map.put("3", new Product(3, "IPHONE8", "2000", "smart phone", "apple"));
        map.put("4", new Product(4, "IPHONEX", "3000", "smart phone", "apple"));
        map.put("5", new Product(5, "IPHONEXS", "4000", "smart phone", "apple"));
    }

    public List<Product> findByAll() {
        return new ArrayList<>(map.values());
    }

    public Product findById(String id) {
        return map.get(id);
    }

    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>(map.values());
        List<Product> findProduct = new ArrayList<>();
        try {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getName().contains(name)) {
                    findProduct.add(products.get(i));
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return findProduct;
    }

        public void add (Product product){
            map.put(String.valueOf(product.getId()), product);
        }

        public void remove (String id){
            map.remove(id);
        }

        public void edit (String id, Product product){
            map.put(id, product);
        }


    }
