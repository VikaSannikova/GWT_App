package com.sannikova.shared;

public class Book {
    private Integer id;
    private String author;
    private String title;
    private String pages;
    private String year;

    public Book() {

    }

    public Book(Integer id, String author, String title, String pages, String year) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}