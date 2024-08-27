package com.devkhishan.bookstoreapi.controller;

import com.devkhishan.bookstoreapi.dto.BookDTO;
import com.devkhishan.bookstoreapi.exception.ResourceNotFoundException;
import com.devkhishan.bookstoreapi.model.Book;

import com.devkhishan.bookstoreapi.service.BookService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO){
        BookDTO createdBook = bookService.createBook(bookDTO);
        return ResponseEntity.ok(createdBook);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(
            @RequestParam(required=false) String title,
            @RequestParam(required=false) String author ){
        List<Book> filteredBooks = bookService.getAllBooks().stream()
                .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                        (author == null || book.getAuthor().equalsIgnoreCase(author)))
                .toList();
        return ResponseEntity.ok().header("Custom-Header","BooksFiltered").body(filteredBooks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@Valid @PathVariable Long id){
        Optional<Book> book = bookService.getBookById(id);
        if(book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }
        else {
            throw new ResourceNotFoundException("Book with id "+id+" not found.");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook){
        Optional<Book> updated = bookService.updateBook(id, updatedBook);
        return updated.map(book -> ResponseEntity.ok().header("Custom-Header","BookUpdated").body(book))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@Valid @PathVariable Long id){
        return bookService.deleteBook(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

}
