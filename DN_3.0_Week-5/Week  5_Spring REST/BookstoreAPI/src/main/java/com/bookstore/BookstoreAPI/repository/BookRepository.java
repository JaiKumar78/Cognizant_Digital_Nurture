package com.bookstore.BookstoreAPI.repository;


import com.bookstore.BookstoreAPI.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
