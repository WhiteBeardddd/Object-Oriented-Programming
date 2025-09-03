package Controllers;

import Models.Note;
import java.util.ArrayList;
import java.util.List;

public class NotesController {
    private final List<Note> notes;

    public NotesController() {
        this.notes = new ArrayList<>();
    }

    // Add a new note
    public void addNote(Note note) {
        notes.add(note);
    }

    // Get all notes
    public List<Note> getNotes() {
        return new ArrayList<>(notes); // return a copy for safety
    }

    // Clear all notes
    public void clearNotes() {
        notes.clear();
    }

    // Optional: delete by index
    public void deleteNoteAt(int index) {
        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
        }
    }

    // Optional: count of notes
    public int getNoteCount() {
        return notes.size();
    }
}
