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
        System.out.println("2. Удалить проект");
        System.out.println("3. Просмотреть список проектов");
        System.out.println("4. Добавить задачу к проекту");
        System.out.println("5. Отметить задачу как выполненную");
        System.out.println("6. Выход");
        while (true) {
            System.out.print("Выберите действие (введите номер): ");

            while (!scan.hasNextInt()) {
                System.out.println("ВВЕДИТЕ ЧИСЛО!!!");
                System.out.print("Выберите действие (введите номер): ");
                scan.next();
            }

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    createProject();
                    break;
                case 2:
                    deleteProject();
                    break;
                case 3:
                    viewProjects();
                    break;
                case 4:
                    addTaskToProject();
                    break;
                case 5:
                    markTaskAsCompleted();
                    break;
                case 6:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Нет такой команды!!!");
            }
        }
    }

    private void markTaskAsCompleted() {
        if (projects.isEmpty()) {
            System.out.println("Список проектов пуст.");
            return;
        }

        viewProjects();
        System.out.print("Введите номер проекта: ");

        while (!scan.hasNextInt()) {
            System.out.println("ВВЕДИТЕ ЧИСЛО!!!");
            System.out.print("Введите номер проекта: ");
            scan.next();
        }

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
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
        System.out.print("Введите номер задачи для отметки как выполненной: ");

        while (!scan.hasNextInt()) {
            System.out.println("ВВЕДИТЕ ЧИСЛО!!!");
            System.out.print("Введите номер задачи для отметки как выполненной: ");
            scan.next();
        }

        int taskIndex = scan.nextInt() - 1;

        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            System.out.println("Некорректный номер задачи.");
            return;
        }
        tasks.get(taskIndex).markAsCompleted();
        System.out.println("Задача \"" + tasks.get(taskIndex).getText() + "\" выполнена.");
    }

    private void addTaskToProject() {
        if (projects.isEmpty()) {
            System.out.println("Список проектов пуст.");
            return;
        }

        viewProjects();

        System.out.print("Введите номер проекта для добавления задачи: ");

        while (!scan.hasNextInt()) {
            System.out.println("ВВЕДИТЕ ЧИСЛО!!!");
            System.out.print("Введите номер проекта для добавления задачи: ");
            scan.next();
        }

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
        if (!projects.isEmpty()) {
            System.out.println("Список проектов:");
            for (int i = 0; i < projects.size(); i++) {
                System.out.print(i + 1 + ". " + projects.get(i).toString());
            }
        }
        else System.out.println("Список проектов пуст.");
    }

    private void createProject() {
        System.out.print("Введите название проекта: ");
        scan.nextLine();
        String name = scan.nextLine();
        projects.add(new ProjectWithTasks(name));
    }

    private void deleteProject() {
        if (projects.isEmpty()) {
            System.out.println("Список проектов пуст.");
            return;
        }
        viewProjects();
        System.out.print("Введите номер проекта для его удаления: ");

        while (!scan.hasNextInt()) {
            System.out.println("ВВЕДИТЕ ЧИСЛО!!!");
            System.out.print("Введите номер проекта для его удаления: ");
            scan.next();
        }

        int projectIndex = scan.nextInt() - 1;


        if (projectIndex < 0 || projectIndex >= projects.size()) {
            System.out.println("Некорректный номер проекта.");
            return;
        }

        projects.remove(projectIndex);
        System.out.println("Проект удалён.");
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}
