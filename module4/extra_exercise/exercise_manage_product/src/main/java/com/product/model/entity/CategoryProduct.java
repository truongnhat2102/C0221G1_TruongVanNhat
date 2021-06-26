package com.product.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "category_product")
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCategoryProduct;
    private String nameCategoryProduct;

    public CategoryProduct(long idCategoryProduct, String nameCategoryProduct) {
        this.idCategoryProduct = idCategoryProduct;
        this.nameCategoryProduct = nameCategoryProduct;
    }

    public CategoryProduct() {
    }

    public long getIdCategoryProduct() {
        return idCategoryProduct;
    }

    public void setIdCategoryProduct(long idCategoryProduct) {
        this.idCategoryProduct = idCategoryProduct;
    }

    public String getNameCategoryProduct() {
        return nameCategoryProduct;
    }

    public void setNameCategoryProduct(String nameCategoryProduct) {
        this.nameCategoryProduct = nameCategoryProduct;
    }
}
