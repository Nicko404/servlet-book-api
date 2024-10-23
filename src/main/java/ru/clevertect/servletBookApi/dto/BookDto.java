package ru.clevertect.servletBookApi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {

    private Integer id;
    private String title;
    private String genre;
    private String author;
    private double price;
}
