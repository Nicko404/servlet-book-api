package ru.clevertect.servletBookApi.repository;

import ru.clevertect.servletBookApi.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements Repository<Book> {

    private final List<Book> books;

    public BookRepository() {
        this.books = new ArrayList<>();
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public Book save(Book book) {
        book.setId(Math.abs(book.hashCode()));
        books.add(book);
        return book;
    }
}
