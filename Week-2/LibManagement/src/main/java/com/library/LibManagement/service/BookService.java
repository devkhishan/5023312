package com.library.LibManagement.service;

import com.library.LibManagement.model.Book;
import com.library.LibManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class BookService {

    @Autowired
    BookRepository repository;

//    List<Book> books = new ArrayList<>(Arrays.asList(
//            new Book(1,"Harry Potter", "JK Rowling"),
//            new Book(2,"Patience", "Naval Ravikant"),
//            new Book(3,"Rich Dad Poor Dad", "Tharkuri")
//    ));
    public List<Book> getBooks(){
        return repository.findAll();
    }

    public Book getBookById(int bookId){
        return repository.findById(bookId).orElse(new Book());
    }

    public void addBook( Book book){
        repository.save(book);
    }

    public void updateBook( Book book){
        repository.save(book);
    }

    public void deleteBook(int bookId){
        repository.deleteById(bookId);
    }
}
