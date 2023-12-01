package com.github.alina;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
public class AuthorResources {
    AuthorDAO authorDAO = new AuthorDAO();
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Author> getAuthors(){
        return authorDAO.getAlAuthors();
    }
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Author getAuthor(@PathParam("id") int id){
        return authorDAO.getAuthor(id);
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Author updateAuthor(@PathParam("id") int id, Author author) {
        authorDAO.updateAuthor(id, author);
        return author;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAuthor( Author author) {
        authorDAO.addAuthor(author);
    }
    @DELETE
    @Path("/{id}")
    public void deleteAuthor(@PathParam("id") int id) {
        authorDAO.deleteAuthor( id);
    }

}
