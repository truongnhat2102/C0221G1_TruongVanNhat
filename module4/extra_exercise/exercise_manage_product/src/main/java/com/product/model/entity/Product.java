package com.product.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idProduct;
    private String nameProduct;
    private String price;
    private String dateToEnter;

    @OneToOne
    @JoinColumn(name = "idCategoryProduct")
    private CategoryProduct categoryProduct;

    public Product() {
    }

    public Product(long idProduct, String nameProduct, String price, String dateToEnter, CategoryProduct categoryProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.dateToEnter = dateToEnter;
        this.categoryProduct = categoryProduct;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDateToEnter() {
        return dateToEnter;
    }

    public void setDateToEnter(String dateToEnter) {
        this.dateToEnter = dateToEnter;
    }

    public CategoryProduct getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(CategoryProduct categoryProduct) {
        this.categoryProduct = categoryProduct;
    }
}
