package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.Book;
import domain.model.Author;

@WebServlet(urlPatterns = "/addBook")
public class AddBookHttpServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession();

        String title = request.getParameter("title");
        String amount = request.getParameter("amount");
        // sprawdzic parametry url
        if (title == null  || title.equals("") ||amount==null || amount.equals("")) {
            response.sendRedirect("addBook.html");
        }
        Author author = (Author) session.getAttribute("author");

        if (author == null) {
            response.sendRedirect("addAuthor.html");
        }

        Book book = new Book();
        book.setAmount(Integer.parseInt(amount));
        book.setTitle(title);
        book.setAuthor(author);
        List<Book> books = new ArrayList<Book>();
        if(session.getAttribute("books")!=null)
            books =(List<Book>) session.getAttribute("accounts");
        books.add(book);
        session.setAttribute("books", books);
        response.sendRedirect("addBook.html");

    }

}