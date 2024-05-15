package week11.j062;

import java.util.ArrayList;
import java.util.Scanner;

public class BookCRUD {
    ArrayList<Book> list;

    public BookCRUD(){
        list = new ArrayList<Book>();
    }

    void addBook(){
        String Bname, Bauth, Bcate;
        int price, year;
        Scanner in = new Scanner(System.in);
        System.out.print("Book > ");
        Bname = in.next();
        in.nextLine();
        System.out.print("Author > ");
        Bauth =in.next();
        in.nextLine();
        System.out.print("Category > ");
        Bcate=in.next();
        in.nextLine();
        System.out.print("Price > ");
        price = in.nextInt();
        System.out.print("Year > ");
        year = in.nextInt();

        Book new_book = new Book(Bname,Bauth,Bcate,price,year);
        list.add(new_book);
    }

    void editBook(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the index of the Book to edit: ");
        int index = in.nextInt();
        in.nextLine();
        if(index < 1 || index > list.size()){
            System.out.println("Invalid index!");
            return;
        }
        Book book = list.get(index - 1);
        System.out.print("New Name (current: " + book.getBname() + ") > ");
        String Bname = in.nextLine();
        System.out.print("New Author (current: " + book.getBauth() + ") > ");
        String Bauth = in.nextLine();
        System.out.print("New Category (current: " + book.getBcate() + ") > ");
        String Bcate = in.nextLine();
        System.out.print("New price (current: " + book.getPrice() + ") > ");
        int price = in.nextInt();
        System.out.print("New Year (current: " + book.getYear() + ") > ");
        int year=in.nextInt();
        book.setBname(Bname);
        book.setBauth(Bauth);
        book.setBcate(Bcate);
        book.setPrice(price);
        book.setYEar(year);
    }

    void listBook(){
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%d - %s\n", i + 1, list.get(i).toString());
        }
    }

    void deleteBook(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the index of the book to delete: ");
        int index = in.nextInt();
        if(index < 1 || index > list.size()){
            System.out.println("Invalid index!");
            return;
        }
        list.remove(index - 1);
        System.out.println("Book deleted successfully.");
    }
}

