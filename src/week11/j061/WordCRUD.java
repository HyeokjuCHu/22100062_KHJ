package week11.j061;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD {
    ArrayList<Word> list;

    public WordCRUD(){
        list = new ArrayList<Word>();
    }

    void addWord(){
        String english, korean;
        int level;
        Scanner in = new Scanner(System.in);
        System.out.print("English > ");
        english = in.next();
        in.nextLine();
        System.out.print("Korean > ");
        korean = in.nextLine();
        System.out.print("Level (1~3) > ");
        level = in.nextInt();
        Word new_word = new Word(english, korean, level);
        list.add(new_word);
    }

    void editWord(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the index of the word to edit: ");
        int index = in.nextInt();
        in.nextLine();
        if(index < 1 || index > list.size()){
            System.out.println("Invalid index!");
            return;
        }
        Word word = list.get(index - 1);
        System.out.print("New English (current: " + word.getEnglish() + ") > ");
        String english = in.nextLine();
        System.out.print("New Korean (current: " + word.getKorean() + ") > ");
        String korean = in.nextLine();
        System.out.print("New Level (1~3) (current: " + word.getLevel() + ") > ");
        int level = in.nextInt();
        word.setEnglish(english);
        word.setKorean(korean);
        word.setLevel(level);
    }

    void listWord(){
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%d - %s\n", i + 1, list.get(i).toString());
        }
    }

    void deleteWord(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the index of the word to delete: ");
        int index = in.nextInt();
        if(index < 1 || index > list.size()){
            System.out.println("Invalid index!");
            return;
        }
        list.remove(index - 1);
        System.out.println("Word deleted successfully.");
    }
}
