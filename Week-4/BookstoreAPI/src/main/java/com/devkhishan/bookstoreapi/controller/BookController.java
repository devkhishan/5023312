package com.devkhishan.bookstoreapi.controller;

import com.devkhishan.bookstoreapi.model.Book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {
    private final List<Book> books = new ArrayList<>();

//    @GetMapping
//    public List<Book> getAllBooks(){
//        return books;
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        for (Book book : books) {
            if (book.getId().equals(id))
                return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(
            @RequestParam(required=false) String title,
            @RequestParam(required=false) String author ){
        List<Book> filteredBooks = books.stream()
                .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                        (author == null || book.getAuthor().equalsIgnoreCase(author)))
                .toList();
        return ResponseEntity.ok(filteredBooks);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        book.setId((long) (books.size()+1));
        books.add(book);
        return book;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook){
        ResponseEntity<Book> responseEntity = getBookById(id);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            Book book = responseEntity.getBody();
            if(book!=null) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                book.setIsbn(updatedBook.getIsbn());
                return ResponseEntity.ok(book);
            }

        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        int i=0;
        for(;i<books.size();i++){
            if(books.get(i).getId().equals(id)){
                books.remove(i);
                break;
            }

        }
        for(i=i+1;i<books.size();i++){
            books.get(i).setId((long)i);
        }
//        books.removeIf(book -> book.getId().equals(id));
    }

}
