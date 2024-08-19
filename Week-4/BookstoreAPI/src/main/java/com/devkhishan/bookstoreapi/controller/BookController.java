package com.devkhishan.bookstoreapi.controller;

import com.devkhishan.bookstoreapi.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {
    private List<Book> books = new ArrayList<>();

    @GetMapping
    public List<Book> getAllBooks(){
        return books;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        for (Book book : books) {
            if (book.getId().equals(id))
                return book;
        }
        return null;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        book.setId((long) (books.size()+1));
        books.add(book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook){
        Book book = getBookById(id);
        if(book!=null){
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setPrice(updatedBook.getPrice());
            book.setIsbn(updatedBook.getIsbn());
            return book;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        books.removeIf(book -> book.getId().equals(id));
    }

}
