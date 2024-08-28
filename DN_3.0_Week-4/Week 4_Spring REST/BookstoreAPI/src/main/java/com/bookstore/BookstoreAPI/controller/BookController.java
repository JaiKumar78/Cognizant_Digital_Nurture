package com.bookstore.BookstoreAPI.controller;

import com.bookstore.BookstoreAPI.dto.BookDTO;
import com.bookstore.BookstoreAPI.mapper.BookMapper;
import com.bookstore.BookstoreAPI.model.Book;
import com.bookstore.BookstoreAPI.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper = BookMapper.INSTANCE;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // POST: Create a new book
    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        Book book = bookMapper.bookDTOToBook(bookDTO);
        Book savedBook = bookService.saveBook(book);
        BookDTO savedBookDTO = bookMapper.bookToBookDTO(savedBook);
        return new ResponseEntity<>(savedBookDTO, HttpStatus.CREATED);
    }

    // GET: Get all books or filter by title and author
    @GetMapping
    public List<BookDTO> getAllBooks(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "author", required = false) String author) {

        List<Book> books;
        if (title != null && author != null) {
            books = bookService.findByTitleAndAuthor(title, author);
        } else if (title != null) {
            books = bookService.findByTitle(title);
        } else if (author != null) {
            books = bookService.findByAuthor(author);
        } else {
            books = bookService.getAllBooks();
        }

        return books.stream()
                .map(bookMapper::bookToBookDTO)
                .collect(Collectors.toList());
    }

    // GET: Get a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        BookDTO bookDTO = bookMapper.bookToBookDTO(book);
        return ResponseEntity.ok(bookDTO);
    }

    // PUT: Update a book by ID
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        Book book = bookMapper.bookDTOToBook(bookDTO);
        book.setId(id);
        Book updatedBook = bookService.updateBook(book);
        BookDTO updatedBookDTO = bookMapper.bookToBookDTO(updatedBook);
        return ResponseEntity.ok(updatedBookDTO);
    }

    // DELETE: Delete a book by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
