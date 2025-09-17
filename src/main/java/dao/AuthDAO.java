package dao;

import Models.User;
import db.AuthDatabaseConnection;

import java.sql.*;

public class AuthDAO {

    public User login(String email, String password) {
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
        return null;
    }

    public boolean register(User user) {
        String sql = "INSERT INTO users (firstname, lastname, email, password) VALUES (?, ?, ?, ?)";
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

    public boolean changePassword(int id, String oldPass, String newPass) {
        String sql = "UPDATE users SET password=? WHERE id=? AND password=?";
        try (Connection conn = AuthDatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newPass);
            stmt.setInt(2, id);
            stmt.setString(3, oldPass);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
