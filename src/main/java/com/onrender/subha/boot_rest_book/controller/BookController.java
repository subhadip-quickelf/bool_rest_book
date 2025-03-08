package com.onrender.subha.boot_rest_book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onrender.subha.boot_rest_book.entity.Book;
import com.onrender.subha.boot_rest_book.service.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return book;
    }

    @DeleteMapping("/books/{id}")
    public Book deleteBook(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        bookService.deleteBook(id);
        return book;
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book) {
        Book b = bookService.updateBook(book);
        return b;
    }

}
