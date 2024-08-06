package com.library.LibManagement.controller;

import com.library.LibManagement.model.Book;
import com.library.LibManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService service;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return service.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable int bookId){
        return service.getBookById(bookId);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book){
        service.addBook(book);
    }

    @PutMapping("/books")
    public void updateBook(@RequestBody Book book){
        service.updateBook(book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBookById(@PathVariable int bookId){
        service.deleteBook(bookId);
    }
}
