package com.capgemini.starterkit.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.starterkit.datatype.BookType;
import com.capgemini.starterkit.entity.Book;
import com.capgemini.starterkit.entity.QBook;
import com.capgemini.starterkit.repository.BookRepository;
import com.capgemini.starterkit.repository.BookRepositoryRevised;
import com.capgemini.starterkit.repository.BookSearchCriteria;
import com.capgemini.starterkit.repository.BookSearchRepository;
import com.capgemini.starterkit.service.BookService;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookSearchRepository searchRepository;

	@Autowired
	private BookRepositoryRevised repositoryRevised;

	@Override
	public Book findBookByIsbn(String isbn) {
		Book foundBook = bookRepository.findBookByIsbn(isbn);
		return foundBook;
	}

	@Override
	public void createBook(String isbn, String title) {
		Book b = new Book();
		b.setTitle(title);
		b.setIsbn(isbn);
		b.setType(BookType.ADVENTURE);
		bookRepository.saveBook(b);
	}

	@Override public void delete(Book book) {
		bookRepository.deleteBook(book);
	}

	@Override public List<Book> findByCriteria(BookSearchCriteria searchCriteria) {
		return searchRepository.findByCriteria(searchCriteria);

	}

	public void findBySpecification() {
		QBook book = QBook.book;
		BooleanExpression myPredicates = book.isbn.eq("12345").and(book.title.eq("rambo"));
		repositoryRevised.findAll(myPredicates);
	}
}
