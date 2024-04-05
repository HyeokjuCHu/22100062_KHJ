package week5;

import java.util.Scanner;
import java.lang.Math;


public class Main {
    public static void main(String[] args) {
        Main pStudio =new Main();
        pStudio.J004();
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

    void J003() {
        Scanner in = new Scanner(System.in);
        double m2_area = in.nextDouble();
        double pyung_area=m2_area/3.305;
        System.out.printf("%.1f",pyung_area);

    }

    void J004() {
        double x1,y1;
        double x2,y2;
        Scanner in = new Scanner(System.in);
        x1=in.nextDouble();
        y1=in.nextDouble();
        x2=in.nextDouble();
        y2=in.nextDouble();
        System.out.printf("%.1f",Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)));
    }
}
