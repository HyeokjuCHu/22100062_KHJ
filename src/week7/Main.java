package week7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        week7.Main pStudio = new week7.Main();
        pStudio.J035();

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

    void J034(){
        String[] usernames = {"kim", "lee", "park", "hong", "choi"};
        String[] passwords = {"1111", "1234", "3456", "3535", "7777"};

        int index1 = -1;
        String name;
        String pass;
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        pass = in.nextLine();

        for (int i = 0; i < usernames.length; i++) {
            if (name.equals(usernames[i])) {
                index1 = i;
                break; // 이름을 찾으면 루프를 종료합니다.
            }
        }

        if (index1 == -1) {
            System.out.print("No user!");
        } else {
            if (passwords[index1].equals(pass)) {
                System.out.print("Login OK!");
            } else {
                System.out.print("Incorrect password!");
            }
        }
    }

    void J035(){
        String date;
        Scanner in = new Scanner(System.in);
        date = in.nextLine();
        int sum=0;
        for (int i = 0; i < 4; i++) {
            char c = date.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                sum += digit;
            }
        }

        // 월(2자리) 부분 합산
        for (int i = 4; i < 6; i++) {
            char c = date.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                if(i==4)sum+=digit*10;
                else sum += digit;
            }
        }

        // 일(2자리) 부분 합산
        for (int i = 6; i < 8; i++) {
            char c = date.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                if(i==6)sum+=digit*10;
                else sum += digit;
            }
        }
        System.out.print(sum);
    }

    void J036(){
        String str;
        String strC="";
        String reverse="";
        Scanner in = new Scanner(System.in);//scanner in

        str=in.nextLine();
        str=str.toLowerCase();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(Character.isAlphabetic(c))
                strC += str.charAt(i);
        }
        for(int i=str.length() - 1; i >= 0;i--){
            char c = str.charAt(i);
            if(Character.isAlphabetic(c))
                reverse += str.charAt(i);
        }
        if(strC.equals(reverse)){
            System.out.print("Yes");
        }else
            System.out.print("No");
    }

    void J037() {
        Scanner in = new Scanner(System.in);

        // Read input strings
        String s1 = in.nextLine();
        String s2 = in.nextLine();

        // Remove non-alphabetic characters and convert to lowercase
        String cleanS1 = s1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String cleanS2 = s2.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Check lengths of cleaned strings
        if (cleanS1.length() != cleanS2.length()) {
            System.out.print("No");
            return;
        }

        // Count frequency of characters in both strings
        int[] charCount = new int[26]; // Assuming only lowercase alphabets
        for (char c : cleanS1.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (char c : cleanS2.toCharArray()) {
            charCount[c - 'a']--;
        }

        // Check if all character counts are zero
        for (int count : charCount) {
            if (count != 0) {
                System.out.print("No");
                return;
            }
        }

        // If all characters match in frequency
        System.out.print("Yes");
    }




}



