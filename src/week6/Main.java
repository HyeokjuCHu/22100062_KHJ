package week6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        week6.Main pStudio =new week6.Main();
        pStudio.J022();
    }
    void J021() {
        Scanner in = new Scanner(System.in);//scanner in
        int x= in.nextInt();

        int people=0;
        for(int i=0;i<x;i++){
            int height = in.nextInt();
            int weight = in.nextInt();
            double bmi;
            bmi = (double) weight / (((double) height / 100) * ((double) height / 100)); //calculate bmi
            people+=bmi >= 25 ? 1:0;
        }

        System.out.printf("%d",people);//output format
    }

    void J022() {
        Scanner in = new Scanner(System.in);
        int count1=0;
        int count2=0;
        int count3=0;
        int count4=0;

        for(int i=0;i<10;i++){
            double m2_area = in.nextDouble();
            double pyung_area=m2_area/3.305;
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

        System.out.printf("small - %d\n",count1);
        System.out.printf("normal - %d\n",count2);
        System.out.printf("large - %d\n",count3);
        System.out.printf("huge - %d",count4);
    }
}
