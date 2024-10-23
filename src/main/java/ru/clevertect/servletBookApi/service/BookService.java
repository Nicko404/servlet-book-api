package ru.clevertect.servletBookApi.service;

import ru.clevertect.servletBookApi.dto.BookDto;
import ru.clevertect.servletBookApi.entity.Book;
import ru.clevertect.servletBookApi.mapper.BookMapper;
import ru.clevertect.servletBookApi.repository.BookRepository;
import ru.clevertect.servletBookApi.repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class BookService implements Service<BookDto> {

    private final Repository<Book> bookRepository;

    public BookService() {
        bookRepository = new BookRepository();
    }

    @Override
    public List<BookDto> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper.INSTANCE::toBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto save(BookDto bookDto) {
        return BookMapper.INSTANCE.toBookDto(
                bookRepository.save(BookMapper.INSTANCE.toBook(bookDto))
        );
    }
}
