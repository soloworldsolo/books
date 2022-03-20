package com.soloworld.books.service;

import com.soloworld.books.repository.BookRepository;
import com.soloworld.books.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        if(book !=null) {
           return bookRepository.save(book);
        }
        return null;
    }
}
