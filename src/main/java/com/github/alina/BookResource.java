package com.github.alina;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
public class BookResource {
    BookDAO bookDAO = new BookDAO();
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Book> getBooks(){
        return bookDAO.getAlBook();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Book getBook(@PathParam("id") int id){
        return bookDAO.getBook(id);
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Book updateBook(@PathParam("id") int id,Book book) {
        bookDAO.updateBook(id, book);
        return book;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBook( Book book) {
        bookDAO.addBook(book);
    }

    @DELETE
    @Path("/{id}")
    public void deleteBook(@PathParam("id") int id) {
        bookDAO.deleteBook(id);
    }
}
