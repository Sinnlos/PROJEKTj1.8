package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import rest.dto.AuthorDto;
import rest.dto.BookDto;

import dao.IRepositoryCatalog;
import domain.model.Book;
import domain.model.Author;

@Path("people")
@Stateless
public class AuthorService {
    IRepositoryCatalog catalog;
    Mapper mapper = new DozerBeanMapper();

    @PersistenceContext
    EntityManager mgr;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AuthorDto> getAll(){
        List<Author> authors =  mgr.createNamedQuery("author.all",Author.class).getResultList();
        List<AuthorDto> results = new ArrayList<AuthorDto>();
        for(Author a: authors)
            results.add(mapper.map(a, AuthorDto.class));
        return results;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getauthor(@PathParam("id") int authorId){
        Author a = mgr.createNamedQuery("author.id", Author.class)
                .setParameter("authorId",authorId)
                .getSingleResult();
        if(a==null)
            return Response.status(404).build();

        return	Response.ok(mapper.map(a, AuthorDto.class)).build();
    }


    @GET
    @Path("/{id}/accounts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookDto> getPersonAccounts(@PathParam("id") int authorId){
        Author a = mgr.createNamedQuery("author.id", Author.class)
                .setParameter("authorId",authorId)
                .getSingleResult();
        if(a==null)
            return null;
        List<BookDto> result = new ArrayList<BookDto>();
        for(Book b: a.getBooks()){
            result.add(mapper.map(a, BookDto.class));
        }
        return result;
    }
}
