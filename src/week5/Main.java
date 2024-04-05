package week5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main pStudio =new Main();
        pStudio.J002();
    }

    void J001() {
        Scanner in = new Scanner(System.in);
        int height = in.nextInt();
        int weight = in.nextInt();
        double bmi;
        bmi = (double) weight / (((double) height / 100) * ((double) height / 100));
        System.out.printf("%.1f",bmi);
    }

    void J002() {
        Scanner in = new Scanner(System.in);
        double c_degree = in.nextDouble();
        double f_degree = c_degree *1.8 + 32;
        System.out.printf("%.1f",f_degree);

    }

}
