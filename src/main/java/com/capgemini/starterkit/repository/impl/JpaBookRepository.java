package com.capgemini.starterkit.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.capgemini.starterkit.entity.Book;
import com.capgemini.starterkit.entity.Book_;
import com.capgemini.starterkit.repository.BookRepository;
import com.capgemini.starterkit.repository.SearchBookRepository;
import com.capgemini.starterkit.repository.BookSearchCriteria;
import com.google.common.collect.Lists;

@Repository
public class JpaBookRepository implements BookRepository, SearchBookRepository {

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

    @Override public List<Book> findBookByCriteria(BookSearchCriteria searchCriteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        List<Predicate> predicates = Lists.newArrayList();

        if(searchCriteria.getIsbn() !=null) {
            predicates.add(
                    criteriaBuilder.equal(root.get(Book_.isbn), searchCriteria.getIsbn())
            );
        }
        if(searchCriteria.getTitle() !=null) {
            predicates.add(
                    criteriaBuilder.equal(root.get(Book_.title), searchCriteria.getTitle())
            );
        }
        if(searchCriteria.getYear() !=null) {
            predicates.add(
                    criteriaBuilder.equal(root.get(Book_.year), searchCriteria.getYear())
            );
        }

        query.where(predicates.toArray(new Predicate[predicates.size()]));

        TypedQuery<Book> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
