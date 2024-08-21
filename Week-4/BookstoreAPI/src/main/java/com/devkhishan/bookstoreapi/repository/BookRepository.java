package com.devkhishan.bookstoreapi.repository;

import com.devkhishan.bookstoreapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
