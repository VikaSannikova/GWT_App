package com.sannikova.server;


import com.sannikova.server.data.Database;
import com.sannikova.shared.model.Book;
import com.sannikova.shared.model.Page;
import com.sannikova.shared.model.Record;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Path("library")
public class LibraryResource {
    // База данных с книгами
    private Database booksDatabase;
    private static final int LIMIT_ROW = 10;

    public LibraryResource() {
        this.booksDatabase = new Database();
        this.booksDatabase.loadFromJsonFile();
    }

    // Получить страницу номер "page"
    private Page currPage(int page) {
        List<Record> rows = new ArrayList<>();

        int i = (page - 1) * LIMIT_ROW;
        while (i < Math.min(page * LIMIT_ROW, booksDatabase.getAll().size())) {
            rows.add(booksDatabase.getAll().get(i));
            i = i + 1;
        }

        Page response = new Page(rows, booksDatabase.getAll().size());
        return response;
    }


    @POST
    @Path("/{page}")
    @Produces(MediaType.APPLICATION_JSON)
    public Page getCurrentPage(@PathParam("page") int page) {
        return currPage(page);
    }

    @POST
    @Path("/add/{page}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Page addBook(Book newBook, @PathParam("page") int page) {
        Record record = new Record();
        record.setBook(newBook);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        record.setTimestamp(now.format(formatter));
        booksDatabase.addNewRecord(record);
        booksDatabase.saveInJsonFile();

        return currPage(page);
    }

    @POST
    @Path("/remove/{page}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Page removeBook(Integer id, @PathParam("page") int page) {
        this.booksDatabase.removeRecord(id);
        this.booksDatabase.saveInJsonFile();

        return currPage(page);
    }
}
