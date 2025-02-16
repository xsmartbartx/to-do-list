import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ToDoListManager {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    displayTasks();
                    break;
                case 3:
                    markTaskAsCompleted();
                    break;
                case 4:
                    editTask();
                    break;
                case 5:
                    removeTask();
                    break;
                case 6:
                    saveAndExit();
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }

        } while (choice != 6);
    }

    private static void displayMenu() {
        System.out.println("\n=== Aplikacja do Zarządzania Listą Zadań ===");
        System.out.println("1. Dodaj zadanie");
        System.out.println("2. Wyświetl listę zadań");
        System.out.println("3. Oznacz zadanie jako ukończone");
        System.out.println("4. Edytuj zadanie");
        System.out.println("5. Usuń zadanie");
        System.out.println("6. Zapisz i wyjdź");
        System.out.print("Wybierz opcję: ");
    }

    private static void addTask() {
        System.out.print("Podaj opis zadania: ");
        String description = scanner.nextLine();

        System.out.print("Podaj datę dodania (np. 2024-01-18): ");
        String dateAdded = scanner.nextLine();

        System.out.print("Podaj priorytet (liczba całkowita): ");
        int priority = scanner.nextInt();

        Task newTask = new Task(description, dateAdded, priority);
        tasks.add(newTask);

        System.out.println("Zadanie dodane pomyślnie!");
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Lista zadań jest pusta.");
        } else {
            // Sortowanie zadań według daty dodania
            Collections.sort(tasks, (task1, task2) -> task1.dateAdded.compareTo(task2.dateAdded));

            System.out.println("\n=== Lista Zadań ===");
            for (Task task : tasks) {
                String status = task.completed ? "[X]" : "[ ]";
                System.out.println(status + " Opis: " + task.description + ", Data dodania: " +
                        task.dateAdded + ", Priorytet: " + task.priority);
            }
        }
    }

    private static void markTaskAsCompleted() {
        displayTasks();
        System.out.print("Podaj numer zadania do oznaczenia jako ukończone (lub 0, aby anulować): ");
        int taskNumber = scanner.nextInt();

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            Task task = tasks.get(taskNumber - 1);
            task.completed = true;
            System.out.println("Zadanie oznaczone jako ukończone.");
        } else {
            System.out.println("Nieprawidłowy numer zadania.");
        }
    }

    private static void editTask() {
        displayTasks();
        System.out.print("Podaj numer zadania do edycji (lub 0, aby anulować): ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            Task task = tasks.get(taskNumber - 1);

            System.out.print("Nowy opis zadania: ");
            task.description = scanner.nextLine();

            System.out.print("Nowa data dodania (np. 2024-01-18): ");
            task.dateAdded = scanner.nextLine();

            System.out.print("Nowy priorytet (liczba całkowita): ");
            task.priority = scanner.nextInt();

            System.out.println("Zadanie edytowane pomyślnie.");
        } else {
            System.out.println("Nieprawidłowy numer zadania.");
        }
    }

    private static void removeTask() {
        displayTasks();
        System.out.print("Podaj numer zadania do usunięcia (lub 0, aby anulować): ");
        int taskNumber = scanner.nextInt();

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Zadanie usunięte pomyślnie.");
        } else {
            System.out.println("Nieprawidłowy numer zadania.");
        }
    }

    private static void saveAndExit() {
        // Tutaj można dodać kod do zapisywania listy zadań do pliku tekstowego lub bazy danych.
        System.out.println("Zapisywanie danych i zamykanie programu.");
        System.exit(0); // Dodaj tę linijkę, aby poprawnie zakończyć działanie programu.
    }

}
