package com.capgemini.starterkit.repository;

import java.util.List;

import com.capgemini.starterkit.entity.Book;

public interface SearchBookRepository {

    public List<Book> findBookByCriteria(BookSearchCriteria searchCriteria);
}
