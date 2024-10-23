package ru.clevertect.servletBookApi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    private Integer id;
    private String title;
    private String genre;
    private String author;
    private double price;
}
