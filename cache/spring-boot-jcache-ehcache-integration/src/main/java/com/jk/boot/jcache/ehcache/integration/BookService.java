package com.jk.boot.jcache.ehcache.integration;

import com.jk.boot.jcache.ehcache.integration.domain.Book;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    public static final String BOOKSTORE_CACHE_NAME = "bookStoreCache";

    @Cacheable(cacheNames = BOOKSTORE_CACHE_NAME, key = "#id", condition = "#id > 0", unless="#result==null")
    public Book getBookById(Integer id) {
        return null;
    }

    @CachePut(cacheNames = BOOKSTORE_CACHE_NAME, key = "#book.id")
    public Book addBook(Book book) {
        System.out.printf("Added book:%s%n", book);
        return book;
    }

}
