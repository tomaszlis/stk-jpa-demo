package com.capgemini.starterkit.repository;

import java.util.List;

import com.capgemini.starterkit.entity.Book;

public interface BookSearchRepository {

    public List<Book> findByCriteria(BookSearchCriteria searchCriteria);
}
