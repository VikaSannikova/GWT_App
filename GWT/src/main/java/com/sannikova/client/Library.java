package com.sannikova.client;

import com.sannikova.shared.Book;
import com.sannikova.shared.Page;
import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/rest/library")
public interface Library extends RestService {

    // Получить текущую страницу
    @POST
    @Path("/{page}")
    @Produces(MediaType.APPLICATION_JSON)
    void getPage(@PathParam("page") int page, MethodCallback<Page> callback);

    // Добавить книгу в БД
    @POST
    @Path("/add/{page}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    void addBook(Book newBook, @PathParam("page") int page, MethodCallback<Page> callback);


    @POST
    @Path("/remove/{page}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    void removeBook(Integer id, @PathParam("page") int page, MethodCallback<Page> callback);


    /**
     * Utility class to get the instance of the Rest Service
     */
    public static final class Util {
        private static Library libraryService = null;

        public static final Library getInstance() {
            if(libraryService == null) {
                libraryService = GWT.create(Library.class);
            }

            return libraryService;
        }

        private Util() {
        }
    }

}
