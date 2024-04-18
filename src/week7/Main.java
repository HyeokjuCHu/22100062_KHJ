package week7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        week7.Main pStudio = new week7.Main();
        pStudio.J033();

    }

    void J031(){
        String userid;
        String password;
        String name;
        Scanner in = new Scanner(System.in);//scanner in

        userid=in.nextLine();
        password=in.nextLine();
        name=in.nextLine();

        if(password.length()<3){
            System.out.print("Error! Password is too short.");
        }else {
            StringBuilder builder = new StringBuilder(password);
            for(int i=2;i<password.length();i++){
                builder.setCharAt(i, '*');
            }
            System.out.printf("%s\n%s\n%s", userid, builder, name);//output format
        }

    }

    void J032(){
        String str;
        String reverse="";
        Scanner in = new Scanner(System.in);//scanner in

        str=in.nextLine();
        for(int i=str.length() - 1; i >= 0;i--){
            reverse += str.charAt(i);
        }
    System.out.print(reverse);
    }

    void J033(){
        int count;
        String name;
        String longest="", shortest="";
        Scanner in = new Scanner(System.in);//scanner in
        count = Integer.parseInt(in.nextLine());
        for(int i=0;i<count;i++){
            name=in.nextLine();
            if(i==0){
                longest=name;
                shortest=name;
            }else {
                if (name.length() > longest.length()) longest=name;
                if (name.length() < shortest.length()) shortest=name;
            }
        }
        System.out.print("Longest: "+longest+"\n");
        System.out.print("Shortest: "+shortest);
    }
}



