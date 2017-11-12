package com.capgemini.starterkit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.starterkit.entity.Book;
import com.capgemini.starterkit.service.BookService;


@RestController
public class TestRestController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/test")
	public String runForTest() {
		
		bookService.createBook("654321", "Pan Tadeusz");


		return bookService.findBookByIsbn("654321").getTitle();
	}

}
