package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.mappers.BookMapper;
import dao.uow.IUnitOfWork;
import domain.model.Book;
import domain.model.Author;

public class BookRepository extends RepositoryBase<Book> implements IBookRepository{

    public BookRepository(Connection connection,
                             BookMapper mapper,
                             IRepository<Author> authorRepo, IUnitOfWork uow) {
        super(connection, mapper,uow);
        mapper.setAuthorRepo(authorRepo);
    }

    @Override
    protected String tableName() {
        // TODO Auto-generated method stub
        return "book";
    }
    @Override
    protected String createTableSql() {
        // TODO Auto-generated method stub
        return "CREATE TABLE book("
                + "id bigint GENERATED BY DEFAULT AS IDENTITY,"
                + "author_id INT,"
                + "amount DECIMAL,"
                + "title VARCHAR(20),"
                + ")";
    }
    @Override
    protected String insertSql() {
        // TODO Auto-generated method stub
        return "INSERT INTO book(author_id, amount, title) VALUES (?, ?, ?)";
    }
    @Override
    protected String deleteSql() {
        // TODO Auto-generated method stub
        return "DELETE FROM book WHERE ID = ?";
    }
    @Override
    protected String updateSql() {
        // TODO Auto-generated method stub
        return "UPDATE book SET author_id = ?, amount = ?, title = ? WHERE ID = ?";
    }
    @Override
    protected String selectByIdSql() {
        // TODO Auto-generated method stub
        return "SELECT * FROM book WHERE id=?";
    }
    @Override
    protected String selectAllSql() {
        // TODO Auto-generated method stub
        return "SELECT * FROM book";
    }

    @Override
    protected void setupInsert(Book entity) throws SQLException {
        insert.setInt(1, entity.getAuthorId());
        insert.setDouble(2, entity.getAmount());
        insert.setString(3, entity.getTitle());

    }

    @Override
    protected void setupUpdate(Book entity) throws SQLException {
        update.setInt(1, entity.getAuthorId());
        update.setDouble(2, entity.getAmount());
        update.setString(3, entity.getTitle());

    }

    public List<Book> byPerson(Author author) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Book> byAuthor(Author author) {
        return null;
    }
}