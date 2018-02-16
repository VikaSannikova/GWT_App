package com.sannikova.shared;

import java.util.ArrayList;
import java.util.List;

// Запись в таблице
public class Record {
    private String timestamp;   // Дата и время добавления книги в базу данных
    private Book book;          // Добавленная книга

    public Record() {
    }

    public Record(String timestamp, Book book) {
        this.timestamp = timestamp;
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<Object> showData() {
        List<Object> listData = new ArrayList<>();

        listData.add(book.getId());
        listData.add(book.getAuthor());
        listData.add(book.getTitle());
        listData.add(book.getPages());
        listData.add(book.getYear());
        listData.add(timestamp);

        return listData;
    }
}
