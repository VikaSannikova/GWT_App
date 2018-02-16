package com.sannikova.client.base_classes;

import com.google.gwt.user.client.ui.*;

public class TableNeedBook extends VerticalPanel {
    private Label pages;
    private Button prev;
    private Button next;


    public TableNeedBook() {
        initialize();
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        Grid grid = new Grid(1, 2);
        grid.setWidget(0, 0, prev);
        grid.setWidget(0, 1, next);
        prev.addStyleName("gwtPageButton");
        next.addStyleName("gwtPageButton");

        horizontalPanel.add(grid);

        this.add(pages);
        this.add(horizontalPanel);
    }

    private void initialize() {
        pages = new Label("Книги: " + 0 + "-" + 0 + " из " + 0);
        pages.addStyleName("gwtTextBox");
        prev = new Button("←");
        next = new Button("→");

        this.getNext().setEnabled(false);
        this.getPrev().setEnabled(false);
    }

    public Button getNext() {
        return this.next;
    }

    public Button getPrev() {
        return this.prev;
    }

    public void updateFooter(int currPage, int limitRow, int countRow) {
        this.getNext().setEnabled(true);
        this.getPrev().setEnabled(true);

        int lastPage = countRow / limitRow + 1;  // Номер последней страницы
        if(countRow % limitRow == 0) {
            lastPage = countRow / limitRow;
        }


        if(currPage == 1) {
            this.getPrev().setEnabled(false);
        }

        if(currPage == lastPage) {
            this.getNext().setEnabled(false);
        }

        if(lastPage == 1) {
            this.getNext().setEnabled(false);
        }


        lastPage = countRow / limitRow + 1;
        int leftBorder;
        int rightBorder;

        if(countRow == 0) {
            leftBorder = 0;
        } else {
            leftBorder = (currPage - 1) * limitRow + 1;
        }

        if(currPage != lastPage) {
            rightBorder = currPage * limitRow;
        } else {
            rightBorder = (currPage - 1) * limitRow + countRow % limitRow;
        }

        pages.setText("Книги: " + leftBorder + "-" + rightBorder + " из " + countRow);
    }
}