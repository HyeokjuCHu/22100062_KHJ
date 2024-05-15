package week11.j062;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();
        pStudio.run();
    }

    public void run(){
        int menu,quit=0;
        Scanner in = new Scanner(System.in);
        BookCRUD manager = new BookCRUD();
        while(true){
            System.out.println("Menu> 1 Add 2 Edit 3 List 4 Delete 0 Exit");
            menu=in.nextInt();
            switch(menu){
                case 1 : manager.addBook(); break;
                case 2 : manager.editBook(); break;
                case 3 : manager.listBook(); break;
                case 4 : manager.deleteBook(); break;
                default: quit=1;
            }
            if(quit==1)break;
        }
    }



}


