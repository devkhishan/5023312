package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    BookRepository bookRepository;
    public BookService(){
        System.out.println("Book Service is Running");
    }

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public void start(){
        System.out.println("Book Service started by Book Repository");
    }

    public void check(){
        System.out.println("Book Service is running");
    }

    public void run(){

        bookRepository.start();
    }
}
