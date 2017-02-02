package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.mappers.BookMapper;

import dao.mappers.AuthorMapper;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;

public class RepositoryCatalog implements IRepositoryCatalog{

    IUnitOfWork uow;
    Connection connection;

    public RepositoryCatalog(String url) throws SQLException, ClassNotFoundException {
        super();

        Class.forName("org.hsqldb.jdbcDriver");
        this.connection = DriverManager.getConnection(url);
        this.uow = new UnitOfWork(this.connection);
    }

    public RepositoryCatalog(IUnitOfWork uow, Connection connection) {
        super();
        this.uow = uow;
        this.connection = connection;
    }


    public IAuthorRepository people() {
        return new AuthorRepository(this.connection, new AuthorMapper(), this.uow);
    }

    public IBookRepository accounts() {
        return new BookRepository(this.connection, new BookMapper(), people(), this.uow);
    }


    public void saveAndClose() {
        try{
            this.uow.commit();
            this.connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }


    public IAuthorRepository authors() {
        return null;
    }

    public IBookRepository books() {
        return null;
    }

    public void save() {
        try {
            this.uow.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
