package com.devkhishan.bookstoreapi.assembler;

import com.devkhishan.bookstoreapi.controller.BookController;
import com.devkhishan.bookstoreapi.dto.BookDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class BookResourceAssembler {

    public EntityModel<BookDTO> toModel(BookDTO bookDTO) {
        EntityModel<BookDTO> bookResource = EntityModel.of(bookDTO);

        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(bookDTO.getId())).withSelfRel();
        bookResource.add(selfLink);

        return bookResource;
    }
}
