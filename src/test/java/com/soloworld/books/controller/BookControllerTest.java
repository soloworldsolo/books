package com.soloworld.books.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soloworld.books.model.Book;
import com.soloworld.books.service.IBookService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class BookControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private IBookService iBookService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createBookTest() throws Exception {

        Book book = new Book();
        book.setName("soloworld");
        book.setIsbn("5175");
        book.setCost("9.99");
        book.setAuthor("solo");
        book.setCategory("biography");

        BDDMockito.given(iBookService.saveBook(ArgumentMatchers.any(Book.class)))
                .willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        var result = mockMvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)));
        result.andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name", CoreMatchers.is("soloworld")))
        ;


    }

    @Test
    public void getBooksTest() throws Exception {
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book(1, "longsoul", "5173", "0.99", "sam", "lost", "plain");
        Book book2 = new Book(2, "livingsoul", "5175", "1.99", "solo", "searching", "special");
        bookList.add(book1);
        bookList.add(book2);
        BDDMockito.given(iBookService.getBooks()).willReturn(bookList);
        var resultActions = mockMvc.perform(get("/books"));
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.size()",CoreMatchers.is(2)))
        ;
    }
}
