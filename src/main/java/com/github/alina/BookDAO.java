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
    public void addBook(Book book) {
        try (Connection connection =DBCconnection.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO persons(name, about, birthYear ) VALUES(?, ?, ?) ");
            stm.setString(1, book.getTitle());
            stm.setString(2, book.getAuthor());
            stm.setDouble(3, book.getPrice());
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBook(int id, Book book) {
        try (Connection connection = DBCconnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE books SET name = ?, category = ?, price = ? WHERE id = ?");
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setDouble(4, book.getPrice());
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int id) {
        try (Connection connection = DBCconnection.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM books WHERE id = ?");
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

