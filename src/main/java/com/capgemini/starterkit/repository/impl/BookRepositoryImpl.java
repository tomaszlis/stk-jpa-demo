package com.capgemini.starterkit.repository.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.starterkit.entity.Book;
import com.capgemini.starterkit.repository.BookRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

//@Repository
public class BookRepositoryImpl implements BookRepository{

    @Override public Book findBookByIsbn(String isbn) {
        throw new NotImplementedException();
    }

    @Override public void saveBook(Book book) {
        throw new NotImplementedException();
    }

    @Override public void deleteBook(Book book) {
        throw new NotImplementedException();
    }
}
