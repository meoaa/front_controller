package domain;

import java.time.LocalDateTime;

public class Todo {
    private static int sequence = 0;
    private int id;
    private String title;
    private LocalDateTime createdAt;
    private boolean completed;

    public Todo(String title) {
        this.id = ++sequence;
        this.title = title;
        this.createdAt = LocalDateTime.now();
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
