package com.sannikova.shared;

import java.util.List;

public class Page {
    private List<Record> rows;  // Строки, которые должны быть отображены на текущей странице
    private int size;           // Общее количество строк в таблице

    public Page() {

    }

    public Page(List<Record> rows, int size) {
        this.rows = rows;
        this.size = size;
    }

    public List<Record> getRows() {
        return rows;
    }
    public void setRows(List<Record> rows) {
        this.rows = rows;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
