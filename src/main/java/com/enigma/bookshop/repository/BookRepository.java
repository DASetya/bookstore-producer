package com.enigma.bookshop.repository;

import com.enigma.bookshop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    List<Book>findBookByTitleContaining(String title);

    @Query(value = "SELECT * FROM mst_book b WHERE b.year = 2002", nativeQuery = true)
    List<Book>getBookByYear();
}
