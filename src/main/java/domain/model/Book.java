package domain.model;

import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "book.all", query = "SELECT b FROM Book b"),
        @NamedQuery(name = "book.id", query = "SELECT b FROM Book b where b.id=:id"),
        @NamedQuery(name = "book.byAuthor", query = "SELECT b FROM Book b where b.author.id=:author_Id")
})
public class Book implements IHaveId{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int authorId;


    @ManyToOne
    private Author author;

    private double amount;
    private String title;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
