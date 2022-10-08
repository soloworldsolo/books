package com.soloworld.books.service;

import com.soloworld.books.model.Book;
import com.soloworld.books.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookService bookService;

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book(1,"soloworld","5175","2.99","solomon","fiction","paperback");

    }

    @Test
    public void createBookServiceTest() {
         given(bookRepository.save(book)).willReturn(book);
        Book book1 = bookService.saveBook(book);
        assertNotNull(book1);
        List<Book> bookList = List.of(book);
         given(bookRepository.findAll()).willReturn(bookList);
        List<Book> books = bookService.getBooks();
         assertEquals(bookList.size(),1);

    }
}
