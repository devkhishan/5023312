package com.library.repository;

import com.library.service.BookService;

public class BookRepository {
    BookService bookService;
    public BookRepository() {
        System.out.println("Book Repository is Running");
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public void start(){
        System.out.println("Book Repository started by Book Service");
    }

    public void run(){
        bookService.start();
    }
}
