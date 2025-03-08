package com.onrender.subha.boot_rest_book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.onrender.subha.boot_rest_book.entity.Book;

@Component
public class BookService {
    private static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book(100, "Java Complete Reference", "Subhadip Dutta"));
        books.add(new Book(101, "Effective Java", "Joshua Bloch"));
        books.add(new Book(102, "Clean Code", "Robert C. Martin"));
        books.add(new Book(103, "The Pragmatic Programmer", "Andy Hunt and Dave Thomas"));
        books.add(new Book(104, "The Mythical Man-Month", "Frederick P. Brooks"));
        books.add(new Book(105, "The Art of Computer Programming", "Donald E. Knuth"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean deleteBook(int id) {
        return books.removeIf(e -> e.getId() == id);
    }

    public Book updateBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == book.getId()) {
                // books.set(i, book);
                if (book.getTitle() != null)
                    books.get(i).setTitle(book.getTitle());
                if (book.getAuthor() != null)
                    books.get(i).setAuthor(book.getAuthor());
                return books.get(i);
            }
        }
        return null;
    }

}
