import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Task {
    String description;
    String dateAdded;
    int priority;
    boolean completed;

    public Task(String description, String dateAdded, int priority) {
        this.description = description;
        this.dateAdded = dateAdded;
        this.priority = priority;
        this.completed = false;
    }
}

