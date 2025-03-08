package com.onrender.subha.boot_rest_book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onrender.subha.boot_rest_book.dao.AuthorRepository;
import com.onrender.subha.boot_rest_book.dao.BookRepository;
import com.onrender.subha.boot_rest_book.entity.Author;
import com.onrender.subha.boot_rest_book.entity.Book;

/* @Component
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

} */

@Component
public class BookService {
    @Autowired
    BookRepository bookRepo;

    @Autowired
    AuthorRepository authorRepo;

    public List<Book> getAllBooks() {
        Iterable<Book> books = bookRepo.findAll();
        return (List<Book>) books;
    }

    public Book getBookById(int id) {
        Optional<Book> book = bookRepo.findById(id);
        return book.isPresent() ? book.get() : null;
    }

    public Book addBook(Book book) {
        Optional<Author> aOpt = authorRepo.findById(book.getAuthor().getId());
        if (aOpt.isPresent()) {
            book.setAuthor(aOpt.get());
        }
        return bookRepo.save(book);
    }

    public void deleteBook(int id) {
        bookRepo.deleteById(id);
    }

    public Book updateBook(Book book) {
        Optional<Book> b = bookRepo.findById(book.getId());
        if (b.isPresent()) {
            if (book.getTitle() != null)
                b.get().setTitle(book.getTitle());
            if (book.getAuthor() != null) {
                Optional<Author> aOpt = authorRepo.findById(book.getAuthor().getId());
                if (aOpt.isPresent()) {
                    book.setAuthor(aOpt.get());
                }
                b.get().setAuthor(book.getAuthor());
            }
            return bookRepo.save(b.get());
        } else {
            return null;
        }
    }
}
