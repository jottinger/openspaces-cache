package org.openspaces.cache.service;


import org.openspaces.cache.model.Book;
import org.springframework.cache.annotation.Cacheable;

public interface BookService {
    @Cacheable("books")
    Book getBook(String bookId);

    int getRequestCount(String bookId);
}
