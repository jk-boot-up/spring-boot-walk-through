package com.jk.boot.jcache.ehcache.integration.domain;

import static org.springframework.util.Assert.notNull;

public class Book {

    private String name;

    private Integer id;

    public Book(String name, Integer id) {
        notNull(name, "name cannot be null");
        notNull(id, "id cannot be null");
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

    public static class Builder {
        private String name;
        private Integer id;

        private Book book;

        public Builder() {
            this.book = new Book();
        }

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Book build() {
            book.id = id;
            book.name = name;
            return book;
        }
    }


}
