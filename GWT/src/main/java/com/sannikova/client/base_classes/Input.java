package com.sannikova.client.base_classes;


import com.sannikova.shared.model.Book;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

public class Input extends VerticalPanel {
    private TextBox author;  // Поле для ввода автора книги
    private TextBox title;   // Поле для ввода заголовка книги
    private TextBox col_pages;   // Поле для ввода кол-ва страниц в книге
    private TextBox year;    // Поле для ввода года издания книги

    private Button addButton;         // Кнопка для добавления книги


    public Input() {
        initialize(); // Создаем компоненты интерфейса

        /* Компоновка */
        Grid leftGrid = new Grid(2, 2);
        Grid rightGrid = new Grid(2, 2);

        // Заполнение leftGrid
        Label author = new Label( "Автор : ");
        author.addStyleName("gwtLabel");
        leftGrid.setWidget(0,0, author);
        leftGrid.setWidget(0, 1, this.author);

        Label title =  new Label("Заголовок : ");
        title.addStyleName("gwtLabel");
        leftGrid.setWidget(1, 0, title);
        leftGrid.setWidget(1,1, this.title);

        // Заполнение rightGrid
        Label pages = new Label("Кол-во страниц : ");
        pages.addStyleName("gwtLabel");
        rightGrid.setWidget(0, 0, pages);
        rightGrid.setWidget(0, 1, col_pages);

        Label year = new Label("Год издания : ");
        year.addStyleName("gwtLabel");
        rightGrid.setWidget(1, 0, year);
        rightGrid.setWidget(1, 1, this.year);

/*        author.addStyleName("gwtTextBox");
        col_pages.addStyleName("gwtTextBox");
        title.addStyleName("gwtTextBox");
        year.addStyleName("gwtTextBox");*/

        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(leftGrid);
        horizontalPanel.add(rightGrid);

        this.add(horizontalPanel);
        this.add(addButton);
    }

    private void initialize() {
        this.author = new TextBox();
        this.title = new TextBox();
        this.col_pages = new TextBox();
        this.year = new TextBox();

        author.addStyleName("gwtTextBox");
        title.addStyleName("gwtTextBox");
        col_pages.addStyleName("gwtTextBox");
        year.addStyleName("gwtTextBox");

        addButton = new Button("Добавить книгу");
        addButton.addStyleName("gwtButton");
    }

    //клик
    public void addBookOnClickHandler(ClickHandler handler) {
        addButton.addClickHandler(handler);
    }

    public Book getInputBook() {
        String Author = author.getText();
        String Title = title.getText();
        String Pages = col_pages.getText();
        String Year = year.getText();

        Book book = new Book(null, Author, Title, Pages, Year);
        return book;
    }
}