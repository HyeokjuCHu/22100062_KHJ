package week12.j071;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main j071 = new Main();
        j071.run();
    }

    public void displayHelp() {
        System.out.println("Commands:");
        System.out.println("add - Add a new todo item");
        System.out.println("del - Delete a todo item");
        System.out.println("edit - Edit a todo item");
        System.out.println("ls - List all todo items");
        System.out.println("ls_name - List all todo items sorted by name");
        System.out.println("ls_date - List all todo items sorted by date");
        System.out.println("ls_desc - List all todo items in reverse order");
        System.out.println("exit - Exit the application");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        TodoCRUD manager = new TodoCRUD();
        boolean quit = false;
        do {
            System.out.print("> ");
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");
            String choice = parts[0];
            switch (choice) {
                case "add":
                    manager.addItem();
                    break;
                case "del":
                    manager.deleteItem();
                    break;
                case "edit":
                    manager.updateItem();
                    break;
                case "ls":
                    manager.printAll();
                    break;
                case "ls_name":
                    manager.sortByName();
                    manager.printAll();
                    break;
                case "ls_date":
                    manager.sortByDate();
                    manager.printAll();
                    break;
                case "ls_desc":
                    manager.reverseList();
                    manager.printAll();
                    break;
                case "?":
                    displayHelp();
                    break;
                case "exit":
                    quit = true;
                    break;
                default:
                    System.out.println("? for help");
                    break;
            }
        } while (!quit);
    }
}
