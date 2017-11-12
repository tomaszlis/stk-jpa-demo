package com.capgemini.starterkit.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.capgemini.starterkit.datatype.BookType;
import com.capgemini.starterkit.entity.Book;

public class BookResultMapper implements RowMapper<Book>{

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book b = new Book();
		b.setIsbn(rs.getString("isbn"));
		b.setTitle(rs.getString("title"));
		b.setActive(rs.getBoolean("active"));
		b.setType(mapBookType(rs.getString("type")));
		return b;
	}

	private BookType mapBookType(String type) {
		if(type !=null) {
			return BookType.valueOf(type);
		}
		else {
			return null;
		}
	}
}
