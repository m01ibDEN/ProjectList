package com.ten0l;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private final List<ProjectWithTasks> projects;
    private final Scanner scan;

    Application() {
        this.projects = new ArrayList<>();
        this.scan = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Добро пожаловать в приложение \"Управление проектами\"!");
        System.out.println("1. Создать проект");
        System.out.println("2. Просмотреть список проектов");
        System.out.println("3. Добавить задачу к проекту");
        System.out.println("4. Отметить задачу как выполненную");
        System.out.println("5. Выход");
        while (true) {
            System.out.print("Выберите действие (введите номер): ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    createProject();
                    break;
                case 2:
                    viewProjects();
                    break;
                case 3:
                    addTaskToProject();
                    break;
                case 4:
                    markTaskAsCompleted();
                    break;
                case 5:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Нет такой команды!!!");
            }
        }
    }

    private void markTaskAsCompleted() {
        viewProjects();
        System.out.print("Введите номер проекта: ");
        int projectIndex = scan.nextInt() - 1;
        if (projectIndex < 0 || projectIndex >= projects.size()) {
            System.out.println("Некорректный номер проекта.");
            return;
        }
        ProjectWithTasks project = projects.get(projectIndex);
        List<Task> tasks = project.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("В этом проекте пока нет задач.");
            return;
        }
        System.out.println("Список задач в проекте \"" + project.getName() + "\":");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task.getText() + (task.isDone() ? " - [X]" : ""));
        }
        System.out.print("Введите номер задачи для отметки как выполненной: ");
        int taskIndex = scan.nextInt() - 1;
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            System.out.println("Некорректный номер задачи.");
            return;
        }
        tasks.get(taskIndex).markAsDone();
        System.out.println("Задача \"" + tasks.get(taskIndex).getText() + "\" выполнена.");
    }

    private void addTaskToProject() {
        viewProjects();
        System.out.print("Введите номер проекта для добавления задачи: ");
        int projectIndex = scan.nextInt() - 1;
        if (projectIndex < 0 || projectIndex >= projects.size()) {
            System.out.println("Некорректный номер проекта.");
            return;
        }
        System.out.print("Введите описание задачи: ");
        scan.nextLine();
        String taskDescription = scan.nextLine();
        Task task = new Task(taskDescription);
        projects.get(projectIndex).add(task);
        System.out.println("Задача успешно добавлена к проекту \"" + projects.get(projectIndex).getName() + "\".");
    }


    private void viewProjects() {
        System.out.println("Список проектов:");
        for (int i = 0; i < projects.size(); i++) {
            System.out.print(i + 1 + ". " + projects.get(i).toString());
        }
    }

    private void createProject() {
        System.out.print("Введите название проекта: ");
        projects.add(new ProjectWithTasks(scan.next()));
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}
