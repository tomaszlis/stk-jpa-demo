package com.capgemini.starterkit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.starterkit.entity.Book;

public interface SpringDataBookRepository extends JpaRepository<Book,Long> {

    public Book findByIsbn(String isbn);

    public List<Book> findByTitle(String title);
}
