package com.jk.boot.jcache.ehcache.integration.controller;


import com.jk.boot.jcache.ehcache.integration.BookService;
import com.jk.boot.jcache.ehcache.integration.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        Optional<Book> optionalBook = bookService.getBookById(id);
        return ResponseEntity.of(optionalBook);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> addBook(@RequestBody Book bookToBeCreated) {
        Book bookCreated = bookService.addBook(bookToBeCreated);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookCreated);
    }
}
