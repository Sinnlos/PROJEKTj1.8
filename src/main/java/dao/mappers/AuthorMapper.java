package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Author;

public class AuthorMapper implements IMapResultSetIntoEntity<Author>{

    public Author map(ResultSet rs) throws SQLException {
        Author a = new Author();
        a.setId(rs.getInt("id"));
        a.setSurname(rs.getString("surname"));
        return a;
    }

}
