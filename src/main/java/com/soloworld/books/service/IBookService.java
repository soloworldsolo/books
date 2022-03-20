package com.soloworld.books.service;

import com.soloworld.books.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookService {
    List<Book> getBooks();

    Book saveBook(Book book);
}
