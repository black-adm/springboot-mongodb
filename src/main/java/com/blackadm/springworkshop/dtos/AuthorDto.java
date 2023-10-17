package com.blackadm.springworkshop.dtos;

import com.blackadm.springworkshop.domain.User;

public class AuthorDto {

    private String id;
    private String name;

    public AuthorDto() {
    }

    public AuthorDto(User obj) {
        id = obj.getId();
        name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
