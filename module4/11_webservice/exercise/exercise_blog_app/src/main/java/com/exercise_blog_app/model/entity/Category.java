package com.exercise_blog_app.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "category_11")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCategory;
    private String nameCategory;

    public Category() {
    }

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
