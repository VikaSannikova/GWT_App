package com.sannikova.client;


import com.sannikova.client.controllers.BookList;
import com.sannikova.client.base_classes.Input;
import com.sannikova.shared.Book;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import org.fusesource.restygwt.client.Defaults;



public class GWTApp implements EntryPoint {
    public void onModuleLoad() {


        //Button button = new Button("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        //RootPanel.get().add(button);
        //button.addStyleName("gwtButton");
        //RootPanel.get().add(button);

        /* Инициализация компонентов интерфейса */
        Input inputFields = new Input();    // Создание полей для ввода
       // inputFields.addStyleName("commonInputPanel");   // width: 100%
        RootPanel.get(/*"container"*/).add(inputFields);

        Defaults.setServiceRoot(GWT.getHostPageBaseURL());
        BookList listBooks = new BookList(RootPanel.get());  // Создание контроллера: base_classes + transport

        /*-----------------------------------------------------------*/

        inputFields.addBookOnClickHandler(clickEvent -> {
            Book book = inputFields.getInputBook();
            book.setId(-1);
            listBooks.addBook(book);
        });
    }
}

