package com.capgemini.starterkit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.capgemini.starterkit.entity.Book;

public interface BookRepositoryRevised extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book>{

}
