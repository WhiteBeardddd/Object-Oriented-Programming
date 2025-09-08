package Models;

import java.time.LocalDateTime;

public class Note {
    private int id;
    private String title;
    private String content;
    private LocalDateTime date;

    public Note(int id, String title, String content, LocalDateTime date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public LocalDateTime getDate() { return date; }
}
