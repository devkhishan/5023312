package com.devkhishan.bookstoreapi.mapper;


import com.devkhishan.bookstoreapi.dto.BookDTO;
import com.devkhishan.bookstoreapi.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO bookToBookDTO(Book book);
    Book bookDTOToBook(BookDTO bookDTO);

}
