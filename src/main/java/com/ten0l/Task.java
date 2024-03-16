package com.ten0l;

public class Task {
    private String text;
    private boolean isComplited = false;

    public Task() {}

    public Task(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void markAsComplited() {
        this.isComplited = true;
    }

    @Override
    public String toString() {
        return this.isComplited ? " [x] " + text : "[ ] " + text;
    }
}