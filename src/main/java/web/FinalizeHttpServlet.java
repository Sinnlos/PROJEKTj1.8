package web;

import domain.model.Book;

import domain.model.Author;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;

@WebServlet(urlPatterns="/finalize")
public class FinalizeHttpServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();

        IRepositoryCatalog catalog;
        try {
            catalog = new RepositoryCatalog("jdbc:hsqldb:hsql://localhost/workdb");
            Author author = (Author)session.getAttribute("author");
            List<Book> books = (List<Book>)session.getAttribute("books");

            catalog.authors().add(author);
            catalog.save();
            int id = catalog.authors().getMaxId();
            for(Book book : books)
            {
                book.setAuthorId(id);
                catalog.books().add(book);
                catalog.save();
                book.setId(catalog.books().getMaxId());

                System.out.println("Zapisano !!");
            }
            catalog.saveAndClose();
            session.removeAttribute("author");
            session.removeAttribute("books");
            response.sendRedirect("index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }





}
