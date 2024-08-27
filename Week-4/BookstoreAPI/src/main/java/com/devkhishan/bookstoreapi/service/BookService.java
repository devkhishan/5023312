package com.devkhishan.bookstoreapi.service;

import com.devkhishan.bookstoreapi.dto.BookDTO;
import com.devkhishan.bookstoreapi.mapper.BookMapper;
import com.devkhishan.bookstoreapi.model.Book;
import com.devkhishan.bookstoreapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    private final BookMapper bookMapper = BookMapper.INSTANCE;

    public BookDTO createBook(BookDTO bookDTO){
        Book book = bookMapper.bookDTOToBook(bookDTO);
        Book savedBook = bookRepository.save(book);
        return bookMapper.bookToBookDTO(savedBook);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }



    public Optional<Book> updateBook(Long id, Book updatedBook){
        if(bookRepository.existsById(id)){
            updatedBook.setId(id);
            return Optional.of(bookRepository.save(updatedBook));
        }
        return Optional.empty();
    }

    public boolean deleteBook(Long id){
        if (bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
