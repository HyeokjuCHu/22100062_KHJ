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
        }

        public void printNumbers() {
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

        Lotto lotto = new Lotto(); // Instantiate a Lotto object
        lotto.remakeAuto(); // Generate lotto numbers
        lotto.printNumbers(); // Print the generated lotto numbers


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
        System.out.println("Auto");
        lotto.remakeAuto();
        lotto.printNumbers();
        System.out.println("Your Lotto number?");
        lotto.remake();
        System.out.println("User");
        lotto.printNumbers();


        int[] userNumbers = new int[6];
        System.out.println("Enter your numbers:");
        for (int i = 0; i < 6; i++) {
            userNumbers[i] = new Scanner(System.in).nextInt();
        }

        int matchedNumbers = lotto.checkLotto(userNumbers);
        System.out.println("You matched " + matchedNumbers + " numbers.");
    }

    class MakePW {
        public MakePW() {
            // 생성자
        }

        public void make(int length) {
            // 주어진 길이를 갖는 암호 문자열 출력하기
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
            // 코드 형식: 알파벳 대문자와 숫자로 구성된 랜덤 코드 생성
            StringBuilder code = new StringBuilder();
            Random random = new Random();

            // 알파벳 부분 생성
            for (int i = 0; i < length1; i++) {
                int index = random.nextInt(26); // 알파벳은 26개
                char c = (char) ('A' + index); // 대문자 알파벳 생성
                code.append(c);
            }

            code.append("-"); // 구분자 추가

            // 숫자 부분 생성
            if (length2 > 0) {
                // 숫자 부분의 첫 자리에 1 이상의 숫자가 오도록 함
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
        int length = 10; // 비밀번호의 길이 (원하는 값으로 변경 가능)
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
