package model.repository;

import model.bean.Product;
import model.bean.ProductCategory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    BaseRepository baseRepository = new BaseRepository();

    public List<ProductCategory> findAllCategory() {
        Connection connection = baseRepository.connectionDatabase();
        List<ProductCategory> productCategories = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from category;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("category_id");
                String nameCategory = resultSet.getString("category_name");
                ProductCategory productCategory = new ProductCategory(id, nameCategory);
                productCategories.add(productCategory);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productCategories;
    }

    public ProductCategory findCategoryById(int id) {
        Connection connection = baseRepository.connectionDatabase();
        ProductCategory productCategory = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from category where category_id = ?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("category_id");
                String nameCategory = resultSet.getString("category_name");
                productCategory = new ProductCategory(id, nameCategory);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productCategory;
    }

    public List<Product> findByAllProduct() {
        Connection connection = baseRepository.connectionDatabase();
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idProduct = resultSet.getInt("product_id");
                String nameProduct = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int idProductCateGory = resultSet.getInt("category_id");
                ProductCategory productCategory = findCategoryById(idProductCateGory);
                Product product = new Product(idProduct, nameProduct, price, quantity, color, description, productCategory);
                productList.add(product);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    public Product findByIdProduct(int id) {
        Connection connection = baseRepository.connectionDatabase();
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idProduct = resultSet.getInt("product_id");
                String nameProduct = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int idProductCateGory = resultSet.getInt("category_id");
                ProductCategory productCategory = findCategoryById(idProductCateGory);
                product = new Product(idProduct, nameProduct, price, quantity,color, description, productCategory);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    public boolean add(Product product){
        Connection connection = baseRepository.connectionDatabase();
        boolean check = false;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into product (product_name,price,quantity,color,description,category_id) " +
                    " values (?,?,?,?,?,?);");
            preparedStatement.setString(1,product.getNameProduct());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,product.getProductCategory().getIdProductCategory());
            check = preparedStatement.executeUpdate()>0;
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    public boolean edit(Product product){
        Connection connection = baseRepository.connectionDatabase();
        boolean check = false;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update product set product_name = ?," +
                            "price= ?,quantity= ?,color= ?,description= ?,category_id= ? where product_id = ?");
            preparedStatement.setString(1,product.getNameProduct());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,product.getProductCategory().getIdProductCategory());
            preparedStatement.setInt(7,product.getIdProduct());
            check = preparedStatement.executeUpdate()>0;
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }

    public boolean delete(int id){
        Connection connection = baseRepository.connectionDatabase();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete product.* from product where product.product_id = ?;");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            check = true;
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return check;
    }
}
