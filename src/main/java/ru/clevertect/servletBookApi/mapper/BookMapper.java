package ru.clevertect.servletBookApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.clevertect.servletBookApi.dto.BookDto;
import ru.clevertect.servletBookApi.entity.Book;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto toBookDto(Book book);

    Book toBook(BookDto bookDto);
}
