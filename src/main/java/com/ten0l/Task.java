package com.ten0l;

public class Task {
    private String text;
    private boolean isDone = false;

    public Task() {}

    public Task(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return this.isDone ? "[x] " + text : "[ ] " + text;
    }
}