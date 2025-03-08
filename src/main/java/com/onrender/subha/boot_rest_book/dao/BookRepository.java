package com.onrender.subha.boot_rest_book.dao;

import org.springframework.data.repository.CrudRepository;

import com.onrender.subha.boot_rest_book.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
