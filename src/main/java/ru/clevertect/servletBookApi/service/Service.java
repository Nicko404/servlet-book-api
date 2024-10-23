package ru.clevertect.servletBookApi.service;

import java.util.List;

public interface Service<T> {

    List<T> getAll();

    T save(T t);
}
