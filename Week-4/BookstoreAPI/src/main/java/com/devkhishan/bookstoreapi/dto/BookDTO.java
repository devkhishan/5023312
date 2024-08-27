package com.devkhishan.bookstoreapi.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    @JsonSerialize(using = TitleSerializer.class)
    @JsonDeserialize(using = TitleDeserializer.class)
    private String title;
    private String author;
    private Double price;
    private String isbn;
}
