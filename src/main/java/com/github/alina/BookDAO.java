package com.github.alina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public List<Book> getAlBook() {
        List<Book> bookList = new ArrayList<>();
        try (Connection connection = DBCconnection.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM persons");
            while (rs.next()) {
                Book book = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

        public Book getBook(int id) {
            try (Connection connection = DBCconnection.getConnection()) {
                PreparedStatement stm = connection.prepareStatement("SELECT * FROM books WHERE id = ?");
                stm.setInt(1, id);
                ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                    return new Book(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getDouble("price"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

