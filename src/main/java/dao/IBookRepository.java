package dao;

import java.util.List;

import domain.model.Book;
import domain.model.Author;

public interface IBookRepository extends IRepository<Book>{
    public List<Book> byAuthor(Author author);
}
