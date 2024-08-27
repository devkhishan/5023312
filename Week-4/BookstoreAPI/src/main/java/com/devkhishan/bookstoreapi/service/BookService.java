package com.devkhishan.bookstoreapi.service;

import com.devkhishan.bookstoreapi.dto.BookDTO;
import com.devkhishan.bookstoreapi.mapper.BookMapper;
import com.devkhishan.bookstoreapi.model.Book;
import com.devkhishan.bookstoreapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    // Create a new book
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = bookMapper.bookDTOToBook(bookDTO);
        Book savedBook = bookRepository.save(book);
        return bookMapper.bookToBookDTO(savedBook);
    }

    // Get all books
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::bookToBookDTO)
                .toList();
    }

    // Get a book by ID
    public Optional<BookDTO> getBookDTOById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::bookToBookDTO);
    }

    // Update an existing book
    public Optional<BookDTO> updateBook(Long id, BookDTO updatedBookDTO) {
        Optional<Book> existingBookOptional = bookRepository.findById(id);
        if (existingBookOptional.isPresent()) {
            Book existingBook = existingBookOptional.get();

            // Map fields from DTO to entity
            existingBook.setTitle(updatedBookDTO.getTitle());
            existingBook.setAuthor(updatedBookDTO.getAuthor());
            existingBook.setPrice(updatedBookDTO.getPrice());
            existingBook.setIsbn(updatedBookDTO.getIsbn());

            Book updatedBook = bookRepository.save(existingBook);
            return Optional.of(bookMapper.bookToBookDTO(updatedBook));
        }
        return Optional.empty();
    }


    // Delete a book by ID
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
