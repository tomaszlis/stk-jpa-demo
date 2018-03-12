package com.capgemini.starterkit.repository;

import com.capgemini.starterkit.entity.Book;

public interface BookRepository {
	
	public Book findBookByIsbn(String isbn);
	
	public void saveBook(Book book);
	
	public void deleteBook(Book book);

}
