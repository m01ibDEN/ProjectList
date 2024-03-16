package com.ten0l;

public class Task {
    private final String text;
    private boolean isCompleted = false;

    public Task(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return this.isCompleted ? " [x] " + this.text : "[ ] " + this.text;
    }
}