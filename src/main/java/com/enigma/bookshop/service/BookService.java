package com.enigma.bookshop.service;

import com.enigma.bookshop.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    public Book addBook(Book book);
    public Book getBookById(String id);
    public List<Book> getAllBook();
    public Book updateBook(Book book);
    public void deleteBook(String id);
    public Page<Book> getBookPerPage(Pageable pageable);
    public List<Book> searchBookTitle(String title);
}
