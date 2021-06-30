package com.exercise_blog_app.model.entity;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "blog_11")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToOne
    @JoinColumn(name = "idCategory")
    private Category category;

    public Blog() {
    }

    public Blog(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
