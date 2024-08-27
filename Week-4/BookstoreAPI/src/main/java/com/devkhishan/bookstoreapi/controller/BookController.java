package com.devkhishan.bookstoreapi.controller;

import com.devkhishan.bookstoreapi.assembler.BookResourceAssembler;
import com.devkhishan.bookstoreapi.dto.BookDTO;
import com.devkhishan.bookstoreapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookResourceAssembler bookResourceAssembler;

    @PostMapping
    public ResponseEntity<EntityModel<BookDTO>> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO createdBook = bookService.createBook(bookDTO);
        EntityModel<BookDTO> bookResource = bookResourceAssembler.toModel(createdBook);
        return ResponseEntity
                .created(linkTo(methodOn(BookController.class).getBookById(createdBook.getId())).toUri())
                .body(bookResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<BookDTO>> getBookById(@PathVariable Long id) {
        Optional<BookDTO> bookDTO = bookService.getBookDTOById(id);
        if (bookDTO.isPresent()) {
            EntityModel<BookDTO> bookResource = bookResourceAssembler.toModel(bookDTO.get());
            return ResponseEntity.ok(bookResource);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<BookDTO>>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        List<EntityModel<BookDTO>> bookResources = books.stream()
                .map(bookResourceAssembler::toModel)
                .toList();
        return ResponseEntity.ok(bookResources);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<BookDTO>> updateBook(@PathVariable Long id, @RequestBody BookDTO updatedBookDTO) {
        Optional<BookDTO> bookDTO = bookService.updateBook(id, updatedBookDTO);
        if (bookDTO.isPresent()) {
            EntityModel<BookDTO> bookResource = bookResourceAssembler.toModel(bookDTO.get());
            return ResponseEntity.ok(bookResource);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (bookService.deleteBook(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
