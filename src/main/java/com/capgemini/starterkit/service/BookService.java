package com.capgemini.starterkit.service;

import com.capgemini.starterkit.entity.Book;

public interface BookService {
	
	public Book findBookByIsbn(String isbn);
	
	public void createBook(String isbn, String title);

}
