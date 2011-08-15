package org.openspaces.cache;

import org.openspaces.cache.model.Book;
import org.openspaces.cache.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@ContextConfiguration
public class TestNoSpringCache extends AbstractTestNGSpringContextTests {
    @Autowired
    BookService service;

    @Test
    public void testConfiguration() {
        Book book = service.getBook("1");
        assertEquals(service.getRequestCount("1"), 1);
        book = service.getBook("1");
        assertEquals(service.getRequestCount("1"), 2);
        book = service.getBook("1");
        assertEquals(service.getRequestCount("1"), 3);
    }
}
