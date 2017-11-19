package com.capgemini.starterkit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.capgemini.starterkit.entity.Book;

public interface BookRepositoryRevised extends JpaRepository<Book, Long>, QueryDslPredicateExecutor<Book>{

}
