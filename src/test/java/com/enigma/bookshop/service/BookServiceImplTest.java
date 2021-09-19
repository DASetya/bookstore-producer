package com.enigma.bookshop.service;

import com.enigma.bookshop.entity.Book;
import com.enigma.bookshop.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class BookServiceImplTest {

    @MockBean
    BookRepository bookRepository;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    BookService bookService;

    @Test
    void addBook() {
        Book book = new Book("A001", "sangkuriang", "description", "publisher", 2020, 200, "Indonesia", 30, 50000);
        bookService.addBook(book);
        verify(bookRepository, times(1)).save(book) ;
    }

    @Test
    void getBookById() {
        when(bookRepository.findById("A001")).thenReturn(java.util.Optional.of(new Book("A001", "sangkuriang", "description", "publisher", 2020, 200, "Indonesia", 30, 50000)));
        Book book = bookService.getBookById(("A001"));

        assertEquals("sangkuriang", book.getTitle());
        assertEquals("description", book.getDescription());
    }

    @Test
    void getAllBook() {
        List<Book> books = new ArrayList<Book>();
        Book book = new Book("A001", "sangkuriang", "description", "publisher", 2020, 200, "Indonesia", 30, 50000);
        Book book2 = new Book("A002", "sangkuriang", "description", "publisher", 2020, 200, "Indonesia", 30, 50000);
        Book book3 = new Book("A003", "sangkuriang", "description", "publisher", 2020, 200, "Indonesia", 30, 50000);
        books.add(book);
        books.add(book2);
        books.add(book3);
        when(bookRepository.findAll()).thenReturn(books);

        // test apakah hasilnya sama
        List<Book> bookList = bookService.getAllBook();
        assertEquals(3, bookList.size());
        verify(bookRepository, times(1)).findAll();
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
    void searchBookTitle() {
    }

    @Test
    void getBookByYear() {
    }
}