package com.github.alina;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    public List<Author> getAlAuthors() {
        List<Author> authorlist = new ArrayList<>();
        try (Connection connection = DBCconnection.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");
            while (rs.next()) {
                Author author = new Author(rs.getInt("id"),rs.getString("name"));
                authorlist.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorlist;
    }
}
