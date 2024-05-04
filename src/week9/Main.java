package week9;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();
        pStudio.J045();
    }

    class Lotto {
        int[] numbers;

        public Lotto() {
            numbers=new int[6];
            remakeAuto();
        }

        public void printNumbers() {
            int temp;
            for(int i=0;i<5;i++){
                for(int j=i+1;j<6;j++){
                    if(numbers[i]>numbers[j]){
                        temp=numbers[j];
                        numbers[j]=numbers[i];
                        numbers[i]=temp;
                    }
                }

            }
            //array.sort로 대체가능

            for(int i=0;i<6;i++){
                System.out.printf("%d: %d\n",i+1,numbers[i]);
            }
        }

        public void remakeAuto() {
            Random rd = new Random();//랜덤 객체 생성
            for (int i = 0; i < 6; i++) {
                int x;
                boolean duplicate;
                do {
                    x = rd.nextInt(45) + 1;
                    duplicate = false;
                    for (int j = 0; j < i; j++) {
                        if (numbers[j] == x) {
                            duplicate = true;
                            break;
                        }
                    }
                } while (duplicate);
                numbers[i] = x;
            }
        }

        public void remake(){
            Scanner in = new Scanner(System.in);//scanner in
            for (int i = 0; i < 6; i++) {
                int x;
                boolean Valid;
                do {
                    x = in.nextInt();
                    Valid = false;
                    for (int j = 0; j < i; j++) {
                        if (numbers[j] == x||x<1||x>45) {
                            Valid = true;
                            break;
                        }
                    }
                } while (Valid);
                numbers[i] = x;
            }
        }

        public int checkLotto(int[] check) {
            int count = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (numbers[i] == check[j]) {
                        count++;
                        break; // Break the inner loop once a match is found
                    }
                }
            }
            return count;
        }

    }

    void J041() {

        Lotto lotto = new Lotto();
        lotto.remakeAuto();
        lotto.printNumbers();


    }

    void J042(){
        Lotto lotto = new Lotto();
        System.out.println("Auto");
        lotto.remakeAuto();
        lotto.printNumbers();
        System.out.println("User");
        lotto.remake();
        lotto.printNumbers();

    }

    void J043() {
        Lotto lotto = new Lotto();

        Scanner in = new Scanner(System.in);//scanner in
        int[] userNumbers = new int[6];
        System.out.println("Enter your numbers:");
        for (int i = 0; i < 6; i++) {
            userNumbers[i] = in.nextInt();
        }
        System.out.println("Auto");
        lotto.remakeAuto();
        lotto.printNumbers();

        int matchedNumbers = lotto.checkLotto(userNumbers);
        System.out.println("You matched " + matchedNumbers + " numbers.");
    }

    class MakePW {
        public MakePW() {
            // 생성자
        }

        public void make(int length) {

            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";

            Random random = new Random();
            StringBuilder password = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                password.append(characters.charAt(index));
            }

            System.out.println("Random Password: " + password.toString());
        }

        public void makeCode(int length1, int length2) {
            StringBuilder code = new StringBuilder();
            Random random = new Random();


            for (int i = 0; i < length1; i++) {
                int index = random.nextInt(26);
                char c = (char) ('A' + index);
                code.append(c);
            }

            code.append("-");

            // 숫자 부분 생성
            if (length2 > 0) {
                int firstDigit = 1 + random.nextInt(9);
                code.append(firstDigit);

                for (int i = 1; i < length2; i++) {
                    int digit = random.nextInt(10); // 숫자는 0부터 9까지
                    code.append(digit);
                }
            }

            System.out.println("Random Code: " + code.toString());
        }
    }


    void J044() {
        MakePW makePW = new MakePW();
        int length = 10;
        makePW.make(length);
    }

    void J045(){
        MakePW passwordGenerator = new MakePW();
        Scanner in = new Scanner(System.in);
        int x,y;
        x=in.nextInt();
        y=in.nextInt();
        passwordGenerator.makeCode(x, y);
    }

}
