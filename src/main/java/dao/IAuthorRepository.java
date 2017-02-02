package dao;

import java.util.List;

import domain.model.Author;

public interface IAuthorRepository
        extends IRepository<Author>{

    public List<Author> withName(String name);
}
