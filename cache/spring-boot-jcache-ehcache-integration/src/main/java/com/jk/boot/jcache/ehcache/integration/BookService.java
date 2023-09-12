package com.jk.boot.jcache.ehcache.integration;

import com.jk.boot.jcache.ehcache.integration.domain.Book;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookService {

    public static final String BOOKSTORE_CACHE_NAME = "bookStoreCache";

    @Cacheable(cacheNames = BOOKSTORE_CACHE_NAME, key = "#id", condition = "#id > 0", unless="#result==null")
    public Optional<Book> getBookById(Integer id) {
        // we have reached here means, we don't have an entry for the given id in the cache, Hence return null
        // This is just to demonstrate that the cache itself is the main storage during the lifetime of the app,
        // just during runtime.
        return Optional.empty();
    }

    @CachePut(cacheNames = BOOKSTORE_CACHE_NAME, key = "#book.id")
    public Book addBook(Book book) {
        // This book will get added to cache with id as the key and Book object as the value
        return book;
    }

}
