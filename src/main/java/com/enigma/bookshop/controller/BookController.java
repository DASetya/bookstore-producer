package com.enigma.bookshop.controller;

import com.enigma.bookshop.entity.Book;
import com.enigma.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id){
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
    }
}
