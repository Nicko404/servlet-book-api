package ru.clevertect.servletBookApi.servlet;

import com.google.gson.Gson;
import ru.clevertect.servletBookApi.dto.BookDto;
import ru.clevertect.servletBookApi.service.BookService;
import ru.clevertect.servletBookApi.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "book-servlet", urlPatterns = "/book")
public class BookServlet extends HttpServlet {

    private final Service<BookDto> bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookDto> books = bookService.getAll();
        String json = new Gson().toJson(books);
        try (PrintWriter writer = resp.getWriter()) {
            writer.println(json);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        BookDto book = gson.fromJson(req.getReader(), BookDto.class);
        String json = gson.toJson(bookService.save(book));

        try (PrintWriter writer = resp.getWriter()) {
            writer.println(json);
        }
    }
}