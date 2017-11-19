package com.capgemini.starterkit.service.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.capgemini.starterkit.entity.Book;
import com.capgemini.starterkit.entity.Book_;

public class BookSpecification {

	public static Specification<Book> byIsbn(String isbn) {
		return new Specification<Book>() {
			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get(Book_.isbn), isbn);
			}
		};
	}

	public static Specification<Book> byTitle(String title) {
		return new Specification<Book>() {
			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get(Book_.title), title);
			}
		};
	}
}