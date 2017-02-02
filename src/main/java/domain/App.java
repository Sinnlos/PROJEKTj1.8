package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;

import dao.uow.UnitOfWork;

import domain.model.Author;

public class App
{
    public static void main( String[] args )
    {
        String url = "jdbc:hsqldb:hsql://localhost/workdb";
        try {
            Connection connection = DriverManager.getConnection(url);
            IRepositoryCatalog catalog = new RepositoryCatalog(new UnitOfWork(connection), connection);

            Author janek = new Author();
            janek.setName("Jan");
            janek.setSurname("Kowalski");

            catalog.authors().add(janek);

            List<Author> pisarz = catalog.authors().withName("pisarz");

            System.out.println( "zapisuje janka" );

            catalog.saveAndClose();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println( "Koniec" );

    }
}