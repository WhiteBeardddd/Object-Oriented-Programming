package dao;

import db.DatabaseConnection;
import Models.Note;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class NotesDAO {
    public void addNote(Note note) {
        String sql = "INSERT INTO notes (title, content) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, note.getTitle());
            stmt.setString(2, note.getContent());
            stmt.executeUpdate();
            System.out.println("Notes Added Successfully: " + note.getTitle());


        } catch (SQLException e) {
            System.err.println("Failed to add note!" + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();
        String sql = "SELECT * FROM notes ORDER BY date DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Note note = new Note(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getTimestamp("date").toLocalDateTime()
                );
                notes.add(note);
            }

            System.out.println("Notes Fetched!: ");

        } catch (SQLException e) {
            System.err.println("Failed to add note!" + e.getMessage());
            e.printStackTrace();
        }
        return notes;
    }

    public void updateNote(int id, String title, String content) {
        String sql = "UPDATE notes SET title=?, content=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, title);
            stmt.setString(2, content);
            stmt.setInt(3, id);
            stmt.executeUpdate();

            System.out.println("Notes Added Successfully: " + title);
        } catch (SQLException e) {
            System.err.println("Failed to add note!" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteNote(int id) {
        String sql = "DELETE FROM notes WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();


            System.out.println("Note#" + id + "successfully deleted");
        } catch (SQLException e) {
            System.err.println("Failed to delete note!" + e.getMessage());
            e.printStackTrace();
        }
    }
}
