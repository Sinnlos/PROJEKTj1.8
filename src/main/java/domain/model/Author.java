package domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
        @NamedQuery(name = "author.all", query = "SELECT a FROM Author a"),
        @NamedQuery(name = "author.id", query = "SELECT a FROM Author a WHERE a.id=:authorId")

})
public class Author implements IHaveId{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;

    @OneToMany(mappedBy="author")
    private List<Book> books;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Book> getBooks() {return books;}
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}

