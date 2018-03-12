package com.capgemini.starterkit.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.starterkit.entity.Book;
import com.capgemini.starterkit.repository.BookRepository;
import com.capgemini.starterkit.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book findBookByIsbn(String isbn) {
		Book foundBook = bookRepository.findBookByIsbn(isbn);
		return foundBook;
	}

	@Override
	public void createBook(String isbn, String title) {
		Book b = new Book();
//		b.setTitle(title);
//		b.setIsbn(isbn);
//		b.setType(BookType.ADVENTURE);
		bookRepository.saveBook(b);
	}

	@Override public void delete(Book book) {
		bookRepository.deleteBook(book);

	}

}
