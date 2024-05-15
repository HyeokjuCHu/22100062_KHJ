package week11.j063;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoCRUD {
    ArrayList<Todo> list;

    public TodoCRUD(){
        list = new ArrayList<Todo>();
    }

    void addTodo(){
        String Tname, Tdetail, Tdate,Tcate;
        Scanner in = new Scanner(System.in);
        System.out.print("Title > ");
        Tname = in.next();
        in.nextLine();
        System.out.print("Detail > ");
        Tdetail =in.next();
        in.nextLine();
        System.out.print("Date > ");
        Tdate=in.next();
        in.nextLine();
        System.out.print("Category > ");
        Tcate = in.next();

        Todo new_todo = new Todo(Tname,Tdetail,Tdate,Tcate);
        list.add(new_todo);
    }

    void editTodo(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the index of the Todo to edit: ");
        int index = in.nextInt();
        in.nextLine();
        if(index < 1 || index > list.size()){
            System.out.println("Invalid index!");
            return;
        }
        Todo todo = list.get(index - 1);
        System.out.print("New Title (current: " + todo.getTname() + ") > ");
        String Tname = in.nextLine();
        System.out.print("New Detail (current: " + todo.getTDetail() + ") > ");
        String TDetail = in.nextLine();
        System.out.print("New Date (current: " + todo.getTDate() + ") > ");
        String TDate = in.nextLine();
        System.out.print("New Category (current: " + todo.getTCate() + ") > ");
        String Tcate = in.nextLine();


        todo.setTname(Tname);
        todo.setTDetail(TDetail);
        todo.setTDate(TDate);
        todo.setTCate(Tcate);
    }

    void listTodo(){
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%d - %s\n", i + 1, list.get(i).toString());
        }
    }

    void deleteTodo(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the index of the todo to delete: ");
        int index = in.nextInt();
        if(index < 1 || index > list.size()){
            System.out.println("Invalid index!");
            return;
        }
        list.remove(index - 1);
        System.out.println("Todo deleted successfully.");
    }
}

