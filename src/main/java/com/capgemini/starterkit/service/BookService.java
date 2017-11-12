package com.capgemini.starterkit.service;

import java.util.List;

import com.capgemini.starterkit.entity.Book;
import com.capgemini.starterkit.repository.BookSearchCriteria;

public interface BookService {
	
	public Book findBookByIsbn(String isbn);
	
	public void createBook(String isbn, String title);

	public void delete(Book book);

	public List<Book> findByCriteria(BookSearchCriteria searchCriteria);

}
