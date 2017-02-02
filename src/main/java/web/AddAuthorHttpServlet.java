package web;

import domain.model.Author;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/addAuthor")
public class AddAuthorHttpServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String nameSession = request.getParameter("name");
        String surnameSession = request.getParameter("surname");

        if (nameSession != null && !nameSession.equals("") && surnameSession != null && !surnameSession.equals("")) {


            Author author = new Author();
            author.setName(nameSession);
            author.setSurname(surnameSession);
            session.setAttribute("author", author);
            response.sendRedirect("addBook.html");
        }
        else {
            response.sendRedirect("addAuthor.html");
        }



    }

}
