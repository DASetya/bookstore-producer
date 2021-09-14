package com.enigma.bookshop.service;

import com.enigma.bookshop.constant.ResponseMessage;
import com.enigma.bookshop.entity.Book;
import com.enigma.bookshop.exception.DataNotFoundException;
import com.enigma.bookshop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Integer id) {
        verify(id);
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book book) {
        verify(book.getId());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer id) {
        verify(id);
        bookRepository.deleteById(id);
    }

    private void verify(Integer id){
        if(!bookRepository.findById(id).isPresent()){
            String message = String.format(ResponseMessage.NOT_FOUND_MESSAGE, "books", id);
            throw new DataNotFoundException(message);
        }
    }

}
