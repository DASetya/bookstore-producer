package com.enigma.bookshop.controller;

import com.enigma.bookshop.entity.Book;
import com.enigma.bookshop.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
class BookControllerTest {

    @MockBean
    BookService bookService;

    @Autowired
    BookController bookController;

    @Autowired
    MockMvc mockMvc;

    @Test
    void createBook() {

        when(bookService.addBook(any(Book.class))).thenReturn(new Book("A001", "sangkuriang", "description", "publisher", 2020, 200, "Indonesia", 30, 50000));
        Book book = new Book("A001", "sangkuriang", "description", "publisher", 2020, 200, "Indonesia", 30, 50000);

        Book book1 = bookController.createBook(book);
        assertThat(book1.getTitle()).isEqualTo("sangkuriang");
    }

    @Test
    void createBookWithResponseHeader() throws Exception {
        Book book = new Book("A001", "sangkuriang", "description", "publisher", 2020, 200, "Indonesia", 30, 50000);
        given(bookService.addBook(any(Book.class))).willAnswer((invocationOnMock -> invocationOnMock.getArgument(0)));

        this.mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(book)).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", Matchers.is(book.getTitle())));
    }

    @Test
    void createBookWithHeaderStatus400() throws Exception {
        this.mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is4xxClientError());
    }

    public static String asJsonString(final Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getBookById() {
    }

    @Test
    void updateBook() {
    }

    @Test
    void deleteBook() {
    }

    @Test
    void getBookPerPage() {
    }

    @Test
    void searchBookByTitle() {
    }

    @Test
    void getBookByYear() {
    }
}