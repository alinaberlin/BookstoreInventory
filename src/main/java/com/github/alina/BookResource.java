package com.github.alina;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
public class BookResource {
    BookDAO personDAO = new BookDAO();
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Book> getBooks(){
        return personDAO.getAlBook();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Book getBook(@PathParam("id") int id){
        return personDAO.getBook(id);
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Book updateProduct(@PathParam("id") int id,Book book) {
        personDAO.updateBook(id, book);
        return book;
    }

}
