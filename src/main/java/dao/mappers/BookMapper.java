package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IRepository;
import domain.model.Book;
import domain.model.Author;

public class BookMapper implements IMapResultSetIntoEntity<Book>{

    IRepository<Author> authorRepo;



    public IRepository<Author> getPersonRepo() {
        return authorRepo;
    }



    public void setPersonRepo(IRepository<Author> personRepo) {
        this.authorRepo = personRepo;
    }



    public Book map(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setAuthorId(rs.getInt("authorid"));
        book.setAmount(rs.getDouble("amount"));
        book.setTitle(rs.getString("title"));
        if(authorRepo!=null)
            book.setAuthor(this.authorRepo.get(book.getAuthorId()));

        return book;
    }

    public void setAuthorRepo(IRepository<Author> authorRepo) {
        this.authorRepo = authorRepo;
    }
}