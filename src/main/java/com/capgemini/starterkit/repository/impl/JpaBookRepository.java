package com.capgemini.starterkit.repository.impl;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.capgemini.starterkit.entity.Book;
import com.capgemini.starterkit.entity.QBook;
import com.capgemini.starterkit.repository.BookRepository;
import com.capgemini.starterkit.repository.BookSearchCriteria;
import com.capgemini.starterkit.repository.BookSearchRepository;
import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

@Repository
public class JpaBookRepository implements BookRepository, BookSearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override public Book findBookByIsbn(String isbn) {
        QBook book = QBook.book;

        JPAQuery<Book> query = new JPAQuery<>(entityManager);
        Book result = query.select(book)
                .from(book)
                .where(book.isbn.eq(isbn))
                .fetchOne();
        return result;
    }

    @Override public void saveBook(Book book) {
        entityManager.persist(book);
    }

    @Override public void deleteBook(Book book) {
        entityManager.remove(book);
    }

    @Override
    public List<Book> findByCriteria(BookSearchCriteria searchCriteria) {
        QBook book = QBook.book;


        List<Predicate> predicates = Lists.newArrayList();
        if(searchCriteria.getTitle() !=null) {
            predicates.add( book.title.eq(searchCriteria.getTitle()));
        }
        if(searchCriteria.getIsbn() !=null) {
            predicates.add( book.isbn.eq(searchCriteria.getIsbn()));
        }
        if(searchCriteria.getYear() !=null) {
            predicates.add( book.year.eq(searchCriteria.getYear()));
        }

        JPAQuery<Book> query = new JPAQuery<>(entityManager);
        return query.select(book)
                .from(book)
                .where(predicates.toArray(new Predicate[predicates.size()]))
                .fetch();
    }
}
