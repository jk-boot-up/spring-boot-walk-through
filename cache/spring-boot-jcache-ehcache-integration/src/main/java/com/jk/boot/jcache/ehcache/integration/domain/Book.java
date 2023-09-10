package com.jk.boot.jcache.ehcache.integration.domain;

import org.springframework.util.Assert;

public class Book {

    private String name;

    private Integer id;

    public Book(String name, Integer id) {
        Assert.notNull(name, "name cannot be null");
        Assert.notNull(id, "id cannot be null");
        this.id = id;
        this.name = name;
    }

    public Book() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
