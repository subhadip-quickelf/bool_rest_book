package com.onrender.subha.boot_rest_book.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.onrender.subha.boot_rest_book.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
    Optional<Author> findByFirstNameAndLastName(String firstName, String lastName);
}
