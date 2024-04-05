package week5;

import java.util.Scanner;
import java.lang.Math;


public class Main {
    public static void main(String[] args) {
        Main pStudio =new Main();
        pStudio.J013();
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

    void J005() {
        int month, day;
        int day_count = 0;
        Scanner in = new Scanner(System.in);
        month = in.nextInt();
        day = in.nextInt();


        if (month == 1) {
            System.out.printf("%d", day);
        } else {
            day_count+=31;
            for (int i = 2; i < month; i++) {
                if (i == 3 || i == 5 || i == 7 || i == 8 || i == 10) {
                    day_count += 31;
                } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                    day_count += 30;
                } else if (i == 2) {
                    day_count += 28;
                }
            }
            System.out.printf("%d", day_count + day);
        }
    }

    void J011() {
        Scanner in = new Scanner(System.in);
        int height, weight;
        double bmi;
        height = in.nextInt();
        weight = in.nextInt();
        bmi = (double) weight / (((double) height / 100) * ((double) height / 100));
        System.out.println(bmi >= 25 ? "Yes" : "No");
    }

    void J012() {
        Scanner in = new Scanner(System.in);
        double m2_area = in.nextDouble();
        double pyung_area=m2_area/3.305;
        System.out.printf("%.1f\n",pyung_area);
        if (pyung_area < 15) {
            System.out.println("small");
        } else if (pyung_area < 30) {
            System.out.println("normal");
        } else if (pyung_area < 50) {
            System.out.println("large");
        } else {
            System.out.println("huge");
        }
    }

    void J013(){
        int kor,eng,math;
        int total;
        double average;
        Scanner in = new Scanner(System.in);
        kor = in.nextInt();
        eng = in.nextInt();
        math = in.nextInt();
        total=kor+eng+math;
        average=(double)total/3;
        System.out.printf("%d %.1f\n",total,average);
        if(kor>=70){
            System.out.print("Korean - Pass\n");
        }else{
            System.out.print("Korean - Fail\n");
        }

        if(eng>=70){
            System.out.print("English - Pass\n");
        }else{
            System.out.print("English - Fail\n");
        }

        if(math>=70){
            System.out.print("Math - Pass");
        }else{
            System.out.print("Math - Fail");
        }
    }

}
