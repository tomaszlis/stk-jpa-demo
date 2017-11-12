package com.capgemini.starterkit.repository.impl;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.capgemini.starterkit.entity.Book;
import com.capgemini.starterkit.repository.BookRepository;

@Repository
public class JpaBookRepository implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override public Book findBookByIsbn(String isbn) {
        List<Book> result= entityManager.createQuery("SELECT b from Book b where b.isbn = :isbn", Book.class)
                .setParameter("isbn", isbn)
                .getResultList();

        if(result !=null && result.size() > 0) {
            return result.get(0);
        }
        else {
            return null;
        }
    }

    @Override public void saveBook(Book book) {
        entityManager.persist(book);
    }

    @Override public void deleteBook(Book book) {
        entityManager.remove(book);
    }
}
