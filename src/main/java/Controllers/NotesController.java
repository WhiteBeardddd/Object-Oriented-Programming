package Controllers;

import dao.NotesDAO;
import Models.Note;

import javax.swing.*;
import java.util.List;

public class NotesController {
    private NotesDAO noteDAO;

    public NotesController() {
        this.noteDAO = new NotesDAO();
    }

    public void addNoteFromUI(String title, String content) {
        if (title.isBlank() || content.isBlank()) {
            JOptionPane.showMessageDialog(null, "Title and content cannot be empty!");
            return;
        }
        noteDAO.addNote(new Note(title, content));
    }

    public List<Note> fetchAllNotes() {
        return noteDAO.getAllNotes();
    }

    public void updateNoteFromUI(int id, String title, String content) {
        noteDAO.updateNote(id, title, content);
    }

    public void deleteNoteFromUI(int id) {
        noteDAO.deleteNote(id);
    }
}
