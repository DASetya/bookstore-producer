package com.enigma.bookshop.controller;

import com.enigma.bookshop.entity.Book;
import com.enigma.bookshop.service.BookService;
import com.enigma.bookshop.utils.PageResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Book getBookById(@PathVariable String id){
        return bookService.getBookById(id);
    }

//    @GetMapping
//    public List<Book> getAllBook(){
//        return bookService.getAllBook();
//    }

    @PutMapping
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id){
        bookService.deleteBook(id);
    }

    @GetMapping
    public PageResponseWrapper<Book> getBookPerPage(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                    @RequestParam(name = "size", defaultValue = "5") Integer size,
                                                    @RequestParam(name = "sortBy", defaultValue = "title") String sortBy,
                                                    @RequestParam(name = "direcction", defaultValue = "ASC") String direction){
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Book> bookPage = bookService.getBookPerPage(pageable);
        return new PageResponseWrapper<>(bookPage);
    }

    @GetMapping("/search")
    public List<Book> searchBookByTitle(@RequestParam String title){
        return bookService.searchBookTitle(title);
    }
}
