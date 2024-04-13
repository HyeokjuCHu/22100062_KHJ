package week6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        week6.Main pStudio = new week6.Main();
        pStudio.J025();

    }

    void J021() {
        Scanner in = new Scanner(System.in);//scanner in
        int x = in.nextInt();
        int people = 0;
        for (int i = 0; i < x; i++) {
            int height = in.nextInt();
            int weight = in.nextInt();
            double bmi;
            bmi = (double) weight / (((double) height / 100) * ((double) height / 100)); //calculate bmi
            people += bmi >= 25 ? 1 : 0;
        }

        System.out.printf("%d", people);//output format
    }

    void J021_1() {//J021에서 비만 index print
        Scanner in = new Scanner(System.in);//scanner in
        int x = in.nextInt();
        int people = 0;
        double[] bmiL = new double[x];

        for (int i = 0; i < x; i++) {
            int height = in.nextInt();
            int weight = in.nextInt();
            double bmi;
            bmi = (double) weight / (((double) height / 100) * ((double) height / 100)); //calculate bmi
            people += bmi >= 25 ? 1 : 0;
            bmiL[i] = bmi;
        }
        for (int i = 0; i < x; i++) {
            if (bmiL[i] >= 25) {
                System.out.printf("%d번째 비만입니다.\n", i + 1);
            }
        }
        System.out.printf("%d", people);//output format
    }

    void J021_2() {//2D array
        Scanner in = new Scanner(System.in);//scanner in
        int x = in.nextInt();
        int people = 0;
        int[][] hwArr = new int[x][2];

        for (int i = 0; i < x; i++) {
            hwArr[i][0] = in.nextInt();
            hwArr[i][1] = in.nextInt();
            double bmi;
            bmi = (double) hwArr[i][1] / (((double) hwArr[i][0] / 100) * ((double) hwArr[i][0] / 100)); //calculate bmi
            people += bmi >= 25 ? 1 : 0;
        }

        System.out.printf("%d", people);//output format
    }

    void J022() {
        Scanner in = new Scanner(System.in);
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;

        for (int i = 0; i < 10; i++) {
            double m2_area = in.nextDouble();
            double pyung_area = m2_area / 3.305;
            if (pyung_area < 15) {
                count1++;
            } else if (pyung_area < 30) {
                count2++;
            } else if (pyung_area < 50) {
                count3++;
            } else {
                count4++;
            }
        }

        System.out.printf("small - %d\n", count1);
        System.out.printf("normal - %d\n", count2);
        System.out.printf("large - %d\n", count3);
        System.out.printf("huge - %d", count4);
    }

    void J023() {
        int count;
        int number;
        int totalsum = 0;
        double average;

        Scanner in = new Scanner(System.in);
        count = in.nextInt();
        for (int i = 0; i < count; i++) {
            number = in.nextInt();
            totalsum += number;
        }
        average = (double) totalsum / (double) count;
        System.out.printf("%d %.1f", totalsum, average);
    }

    void J024() {
        int[] numbers = new int[10];


        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            numbers[i] = in.nextInt();
        }
        int first = numbers[0];
        int second = numbers[0];
        int second_max_index = -1;

        for (int i = 0; i < 10; i++) {
            if (numbers[i] > first) {
                second = first;
                second_max_index = i;
                first = numbers[i];
            } else if (numbers[i] > second && numbers[i] != first) {
                second = numbers[i];
                second_max_index = i;
            }
        }

        System.out.printf("[%d] %d", second_max_index, second);
    }

    void J025() {
        int[] monthdays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month, day;
        int day_count = 0;
        Scanner in = new Scanner(System.in);
        month = in.nextInt();
        day = in.nextInt();
        if (month > 12 || month < 1 || monthdays[month - 1] < day) {
            System.out.print("Wrong date!");
        } else {
            if (month != 1) {

                for (int i = 0; i < month - 1; i++) {
                    day_count += monthdays[i];
                }
            }
            day_count += day;
            System.out.printf("%d", day_count);
        }
    }

    void Prac1() {
        int hour;
        int minute;
        Scanner in = new Scanner(System.in);
        int count4 = 0;

        hour = in.nextInt();
        minute = in.nextInt();
        for (int i = 0; i <= hour; i++) {
            int endMinute = 59;
            if (i == hour) {
                endMinute = minute;
            }
            for (int j = 0; j <= endMinute; j++) {
                if (i / 10 == 4) {
                    count4++;
                }
                if (i % 10 == 4) {
                    count4++;
                }
                if (j / 10 == 4) {
                    count4++;
                }
                if (j % 10 == 4) {
                    count4++;
                }
            }
        }
        System.out.printf("%d번", count4);
    }



}
