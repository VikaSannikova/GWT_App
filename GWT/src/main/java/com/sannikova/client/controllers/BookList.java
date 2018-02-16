package com.sannikova.client.controllers;

import com.sannikova.client.Library;
import com.sannikova.client.base_classes.Table;
import com.sannikova.client.base_classes.TableNeedBook;
import com.sannikova.shared.model.Book;
import com.sannikova.shared.model.Page;
import com.sannikova.shared.model.Record;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

public class BookList {
    private static final int max_col = 10;
    private int countRow = 0;
    private int currPage = 1;

    private Table table;
    private TableNeedBook pagin_books;

    private void initialize_component(RootPanel rootPanel) {
        String[] hat ={"id", "Автор", "Заголовок", "Кол-во страниц", "Год Издания", "Время добавления", "Удалить"};
        this.table = new Table(hat);
        rootPanel.add(this.table);

        this.pagin_books = new TableNeedBook();
        rootPanel.add(this.pagin_books);
    }

    public BookList(RootPanel rootPanel) {
        this.initialize_component(rootPanel);


        pagin_books.getNext().addClickHandler(clickEvent -> {
            currPage = currPage + 1;
            loadCurrPage();
        });

        pagin_books.getPrev().addClickHandler(clickEvent -> {
            currPage = currPage - 1;
            loadCurrPage();
        });

        loadCurrPage();
    }


    private void addBook(Record record) {
        List<Object> rowData = record.showData();

        Button deleteButton = new Button("Х");
        deleteButton.addStyleName("gwtRemoveButton");

        deleteButton.addClickHandler(clickEvent -> {
            int rowIndex = table.getCellForEvent(clickEvent).getRowIndex();  // Строка которую нужно удалить
            Label labelBookId = (Label) table.getWidget(rowIndex, 0); // Получаем виджет в котором записан Id
            int removeBookId = Integer.parseInt(labelBookId.getText());      // Получаем id книги которую нужно удалить

            deleteBook(removeBookId);
        });

        rowData.add(deleteButton);
        table.addRow(rowData);
        table.applyZebra();
    }

    public void showPage(Page page) {
        this.table.clear();
        for(Record record : page.getRows()) {
            this.addBook(record);
        }

        this.countRow = page.getSize();
        pagin_books.updateFooter(currPage, max_col, countRow);
    }


    //транпорт(!)загрузить, добавить книгу, удалить книгу

    private void loadCurrPage() {
        Library.Util.getInstance().getPage(this.currPage, new MethodCallback<Page>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {

            }

            @Override
            public void onSuccess(Method method, Page page) {
                showPage(page);
            }
        });
    }

    public void addBook(Book newBook) {

        newBook.setId(countRow + 1);

        Library.Util.getInstance().addBook(newBook, this.currPage, new MethodCallback<Page>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {

            }

            @Override
            public void onSuccess(Method method, Page page) {
                showPage(page);
            }
        });
    }

    public void deleteBook(Integer id) {
        Library.Util.getInstance().removeBook(id, currPage, new MethodCallback<Page>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {

            }

            @Override
            public void onSuccess(Method method, Page page) {
                showPage(page);
            }
        });
    }
}
