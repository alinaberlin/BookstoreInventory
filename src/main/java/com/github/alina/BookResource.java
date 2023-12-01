package com.github.alina;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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


}
