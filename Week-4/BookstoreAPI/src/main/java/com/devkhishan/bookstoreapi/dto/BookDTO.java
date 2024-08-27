package com.devkhishan.bookstoreapi.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO extends RepresentationModel<BookDTO> {
    private Long id;



    @JsonSerialize(using = TitleSerializer.class)
    @JsonDeserialize(using = TitleDeserializer.class)
    @NotBlank(message = "Title is mandatory")
    @Size(max = 100, message = "Title can be up to 100 characters")
    private String title;

    @NotBlank(message = "Author is mandatory")
    @Size(max = 100, message = "Author can be up to 100 characters")
    private String author;

    @NotNull(message = "Price is mandatory")
    @Min(value = 0, message = "Price must be positive")
    private Double price;

    @NotBlank(message = "ISBN is mandatory")
    @Size(max = 13, message = "ISBN can be up to 13 characters")
    private String isbn;
}
