package com.ten0l;

import java.util.ArrayList;
import java.util.List;

public class ProjectWithTasks {
    private final String name;
    private final List<Task> tasks;

    public ProjectWithTasks(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
        System.out.println("Проект успешно создан.");
    }

    public String getName() {
        return name;
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
