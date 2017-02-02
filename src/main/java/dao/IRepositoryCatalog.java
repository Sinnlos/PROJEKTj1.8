package dao;

public interface IRepositoryCatalog {

    public IAuthorRepository authors();
    public IBookRepository books();

    public void save();
    public void saveAndClose();

}