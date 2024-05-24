package week12.j071;

import java.util.*;

public class TodoCRUD implements iCRUD {
    private ArrayList<TodoItem> list;

    public TodoCRUD() {
        this.list = new ArrayList<TodoItem>();
    }

    @Override
    public Object createItem() {
        return null;
    }

    @Override
    public int addItem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Add a Todo item\nEnter the title: ");
        String title = sc.nextLine().trim();
        if (isDuplicated(title)) {
            System.out.println("Title can't be duplicated");
            return 1;
        }
        System.out.print("Enter the detail: ");
        String desc = sc.nextLine().trim();
        TodoItem t = new TodoItem(title, desc);
        this.list.add(t);
        System.out.println("Item added.");
        return 0;
    }

    @Override
    public int updateItem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Edit a Todo item\nEnter the title of the item to edit: ");
        String title = sc.nextLine().trim();
        TodoItem itemToEdit = findItemByTitle(title);
        if (itemToEdit == null) {
            System.out.println("Item not found");
            return 1;
        }
        System.out.print("Enter new detail: ");
        String desc = sc.nextLine().trim();
        itemToEdit.setDetail(desc);
        System.out.println("Item edited.");
        return 0;
    }

    @Override
    public int deleteItem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Delete a Todo item\nEnter the title of the item to remove: ");
        String title = sc.nextLine().trim();
        TodoItem itemToDelete = findItemByTitle(title);
        if (itemToDelete == null) {
            System.out.println("Item not found");
            return 1;
        }
        this.list.remove(itemToDelete);
        System.out.println("Item deleted.");
        return 0;
    }

    @Override
    public int printItem() {
        return 0;
    }

    private boolean isDuplicated(String title) {
        for (TodoItem item : this.list) {
            if (title.equals(item.getTitle())) {
                return true;
            }
        }
        return false;
    }

    private TodoItem findItemByTitle(String title) {
        for (TodoItem item : this.list) {
            if (title.equals(item.getTitle())) {
                return item;
            }
        }
        return null;
    }

    public int printAll() {
        System.out.println("Total " + this.list.size() + " items");
        for (TodoItem item : this.list) {
            System.out.println(item.toString());
        }
        return 0;
    }

    public void sortByName() {
        Collections.sort(this.list, new TodoItemNameComparator());
    }

    public void sortByDate() {
        Collections.sort(this.list, new TodoItemDateComparator());
    }

    public void reverseList() {
        Collections.reverse(this.list);
    }
}

class TodoItemNameComparator implements Comparator<TodoItem> {
    @Override
    public int compare(TodoItem o1, TodoItem o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}

class TodoItemDateComparator implements Comparator<TodoItem> {
    @Override
    public int compare(TodoItem o1, TodoItem o2) {
        return o1.getReg_date().compareTo(o2.getReg_date());
    }
}
