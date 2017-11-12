package com.capgemini.starterkit.repository;

import com.capgemini.starterkit.datatype.BookType;

public class BookSearchCriteria {

    private String isbn;

    private String title;

    private Integer year;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
