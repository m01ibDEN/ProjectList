package com.ten0l;

import java.util.ArrayList;
import java.util.List;

public class ProjectWithTasks {
    private String name;
    private List<Task> tasks;

    public ProjectWithTasks() {}

    public ProjectWithTasks(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
        System.out.println("Проект успешно создан.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void add(Task task) {
        tasks.add(task);
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder(this.name + "\n");

        if (tasks != null) {
            for (Task task : this.tasks) {
                temp.append("\t").append("-").append(task).append("\n");
            }
        }

        return temp.toString();
    }
}
