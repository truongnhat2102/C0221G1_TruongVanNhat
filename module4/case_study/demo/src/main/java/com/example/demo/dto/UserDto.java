package com.example.demo.dto;


import com.example.demo.model.entity.TypeUser;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserDto {
    private long id;
    @NotBlank(message = "is empty")
    @Pattern(regexp = "[a-z /s]{1,}")
    private String name;
    private TypeUser typeUser;

    public UserDto() {
    }

    public UserDto(@NotBlank(message = "is empty") @Pattern(regexp = "[a-z /s]{1,}") String name, TypeUser typeUser) {
        this.name = name;
        this.typeUser = typeUser;
    }

    public UserDto(long id, @NotBlank(message = "is empty") @Pattern(regexp = "[a-z /s]{1,}") String name, TypeUser typeUser) {
        this.id = id;
        this.name = name;
        this.typeUser = typeUser;
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

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }
}
