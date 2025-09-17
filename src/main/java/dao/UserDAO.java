package dao;

import Models.User;
import db.AuthDatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public boolean registerUser(User user) {
        String sql = "INSERT INTO users (password, email, created_at, firstname, lastname) VALUES (?, ?, ?, ?, NOW())";

        try (Connection conn = AuthDatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getFirstname());
            stmt.setString(2, user.getLastname());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User loginUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email=? AND password=?";
        try (Connection conn = AuthDatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("firstname"),
                        rs.getString("lastname")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // invalid login
    }

    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id=?";
        try (Connection conn = AuthDatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("firstname"),
                        rs.getString("lastname")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = AuthDatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("firstname"),
                        rs.getString("lastname")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean updateUser(User user) {
        String sql = "UPDATE users SET firstname=?, lastname=?, email=? WHERE id=?";
        try (Connection conn = AuthDatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getFirstname());
            stmt.setString(2, user.getLastname());
            stmt.setString(3, user.getEmail());
            stmt.setInt(4, user.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id=?";
        try (Connection conn = AuthDatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
