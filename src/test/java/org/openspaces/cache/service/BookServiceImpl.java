package org.openspaces.cache.service;

import org.openspaces.cache.model.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    Map<String, Integer> callCount = new HashMap<String, Integer>();

    @Override
    public Book getBook(String bookId) {
        if (callCount.get(bookId) == null) {
            callCount.put(bookId, 1);
        } else {
            callCount.put(bookId, callCount.get(bookId) + 1);
        }
        return new Book(bookId);
    }

    @Override
    public int getRequestCount(String bookId) {
        return callCount.get(bookId);
    }
}
