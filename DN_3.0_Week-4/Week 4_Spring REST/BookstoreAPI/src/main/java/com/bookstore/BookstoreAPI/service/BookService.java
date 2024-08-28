package com.bookstore.BookstoreAPI.service;

import com.bookstore.BookstoreAPI.exception.ResourceNotFoundException;
import com.bookstore.BookstoreAPI.model.Book;
import com.bookstore.BookstoreAPI.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Save a new book
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Retrieve all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Find books by title
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    // Find books by author
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    // Find books by both title and author
    public List<Book> findByTitleAndAuthor(String title, String author) {
        return bookRepository.findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCase(title, author);
    }

    // Get a book by ID
    public Book getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        } else {
            throw new ResourceNotFoundException("Book not found with id: " + id);
        }
    }

    // Update an existing book
    public Book updateBook(Book book) {
        // Check if the book exists
        if (!bookRepository.existsById(book.getId())) {
            throw new ResourceNotFoundException("Book not found with id: " + book.getId());
        }
        return bookRepository.save(book);
    }

    // Delete a book by ID
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }
}
