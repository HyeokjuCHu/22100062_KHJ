package week10;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();
        pStudio.J055();
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

        public void make(int length, int amount){
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";


            for(int j=0;j<amount;j++) {
                Random random = new Random();
                StringBuilder password = new StringBuilder();
                for (int i = 0; i < length; i++) {
                    int index = random.nextInt(characters.length());
                    password.append(characters.charAt(index));
                }
                System.out.printf("Random Password #%d: %s\n" ,j+1, password.toString());
            }
        }
    }

    void J051() {
        MakePW makePW = new MakePW();
        int x,y;
        Scanner in = new Scanner(System.in);
        x=in.nextInt();
        y=in.nextInt();
        makePW.make(x,y);

    }
    class BlackJack{
        String[] arrayCard;
        String[] deckL;

        public BlackJack(int deck){
            arrayCard=new String[deck*52];
            deckL=new String[52];

            char[] alpa={'S','D','H','C'};
            String[] num={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

            int index=0;
            for(int i=0;i<4;i++){
                for(int j=0;j<13;j++){
                    deckL[index++]=alpa[i]+"-"+num[j];
                }
            }

            for(int i=0;i<arrayCard.length;i++){
                arrayCard[i]=deckL[i%52];
            }
        }

        public void suffle(){


        }

        public void printALl(){
            for(int i=0;i<arrayCard.length;i++){
                System.out.println(arrayCard[i]);
            }
        }

    }


    class Score {
        int count;
        int[][] jumsu;
        int[] sum_student;
        double[] average_student;
        int[] sum_subject; // 각 과목별 총점을 저장할 배열
        double[] average_subject; // 각 과목별 평균을 저장할 배열
        int[] sum_class;
        double[] average_class;

        public Score(int count) {
            this.count = count;
            jumsu = new int[count][3]; // 5명의 학생, 각 학생당 3과목의 점수
            sum_student = new int[count]; // 각 학생별 총점
            average_student = new double[count]; // 각 학생별 평균
            sum_subject = new int[3]; // 국어, 영어, 수학 총점
            average_subject = new double[3]; // 국어, 영어, 수학 평균
        }

        public void getScore() {
            Scanner in = new Scanner(System.in);//scanner in
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + "번째 학생의 국어, 영어, 수학 점수를 입력하세요: ");
                for (int j = 0; j < 3; j++) {
                    jumsu[i][j] = in.nextInt();
                    sum_student[i] += jumsu[i][j]; // 각 학생별 총점 계산
                    sum_subject[j] += jumsu[i][j]; // 각 과목별 총점 계산
                }
                average_student[i] = (double) sum_student[i] / 3; // 각 학생별 평균 계산
            }
            // 각 과목별 평균 계산
            for (int i = 0; i < 3; i++) {
                average_subject[i] = (double) sum_subject[i] / count;
            }
        }

        public void printScore() {
            char[] grades = new char[count]; // 학생들의 등급을 저장할 배열

            System.out.println("\n학생별 점수와 등급:");
            for (int i = 0; i < count; i++) {
                System.out.print((i + 1) + "번째 학생의 국어, 영어, 수학 점수: ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(jumsu[i][j] + " ");
                }
                System.out.print("총점: " + sum_student[i] + ", ");
                System.out.printf("평균: %.2f, ", average_student[i]);
                // 등급 설정
                if (average_student[i] >= 90) {
                    grades[i] = 'A';
                } else if (average_student[i] >= 80) {
                    grades[i] = 'B';
                } else if (average_student[i] >= 70) {
                    grades[i] = 'C';
                } else if (average_student[i] >= 60) {
                    grades[i] = 'D';
                } else {
                    grades[i] = 'F';
                }
                System.out.println("등급: " + grades[i]);
            }
        }

        public void printScore(int num) {
            System.out.print((num) + "번째 학생의 국어, 영어, 수학 점수: ");

            for (int j = 0; j < 3; j++) {
                System.out.print(jumsu[num-1][j] + " ");
            }
            System.out.print("총점: " + sum_student[num-1] + ", ");
            System.out.printf("평균: %.2f, ", average_student[num-1]);
            // 등급 설정
            if (average_student[num-1] >= 90) {
                System.out.println("등급: " + 'A');
            } else if (average_student[num-1] >= 80) {
                System.out.println("등급: " + 'B');
            } else if (average_student[num-1] >= 70) {
                System.out.println("등급: " + 'C');
            } else if (average_student[num-1] >= 60) {
                System.out.println("등급: " + 'D');
            } else {
                System.out.println("등급: " + 'F');
            }


        }

        public void printScore(int num, String classname){

            System.out.println("국어 총점: " + sum_subject[0] + ", 평균: " + average_subject[0]);
            System.out.println("영어 총점: " + sum_subject[1] + ", 평균: " + average_subject[1]);
            System.out.println("수학 총점: " + sum_subject[2] + ", 평균: " + average_subject[2]);

            System.out.print((num) + "번째 학생의 국어, 영어, 수학 점수: ");

            for (int j = 0; j < 3; j++) {
                System.out.print(jumsu[num-1][j] + " ");
            }
            System.out.print("총점: " + sum_student[num-1] + ", ");
            System.out.printf("평균: %.2f, ", average_student[num-1]);
            // 등급 설정
            if (average_student[num-1] >= 90) {
                System.out.println("등급: " + 'A');
            } else if (average_student[num-1] >= 80) {
                System.out.println("등급: " + 'B');
            } else if (average_student[num-1] >= 70) {
                System.out.println("등급: " + 'C');
            } else if (average_student[num-1] >= 60) {
                System.out.println("등급: " + 'D');
            } else {
                System.out.println("등급: " + 'F');
            }
        }



    }
    void J052() {
        Score score = new Score(5); // 5명의 학생을 다룰 수 있는 Score 객체 생성
        score.getScore(); // 학생들의 점수 입력
        score.printScore(); // 학생들의 점수 출력
    }

    void J053() {
        Score score = new Score(5); // 5명의 학생을 다룰 수 있는 Score 객체 생성
        Scanner in = new Scanner(System.in);//scanner in

        score.getScore(); // 학생들의 점수 입력
        int x=in.nextInt();

        score.printScore(x); // 학생들의 점수 출력
    }

    void J054() {
        Score score = new Score(5); // 5명의 학생을 다룰 수 있는 Score 객체 생성
        Scanner in = new Scanner(System.in);//scanner in

        score.getScore(); // 학생들의 점수 입력
        int x=in.nextInt();

        score.printScore(x); // 학생들의 점수 출력
    }

    class BMICalculator {
        int height, weight; // 신장 (cm), 체중 (kg)
        double bmi; // 비만도
        int level; // 비만도 등급(1~4)
        String name; // 이름

        // 생성자
        public BMICalculator() {
            this.height = 0;
            this.weight = 0;
            this.bmi = 0.0;
            this.level = 0;
            this.name = "";
        }

        // 이름, 신장, 체중을 입력받아 비만도와 비만등급을 계산
        public void getHW() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("이름을 입력하세요: ");
            this.name = scanner.nextLine();
            System.out.print("신장(cm)을 입력하세요: ");
            this.height = scanner.nextInt();
            System.out.print("체중(kg)을 입력하세요: ");
            this.weight = scanner.nextInt();

            // BMI 계산
            double heightInMeter = this.height / 100.0; // 신장을 미터 단위로 변환
            this.bmi = this.weight / (heightInMeter * heightInMeter);

            // 비만도 등급 판정
            if (this.bmi < 18.5) {
                this.level = 1;
            } else if (this.bmi >= 18.5 && this.bmi < 25) {
                this.level = 2;
            } else if (this.bmi >= 25 && this.bmi < 30) {
                this.level = 3;
            } else {
                this.level = 4;
            }
        }

        // 이 사람의 이름, 신장, 체중, 비만도, 비만등급을 출력
        public void printBMI() {
            System.out.println("이름: " + this.name);
            System.out.println("신장: " + this.height + "cm");
            System.out.println("체중: " + this.weight + "kg");
            System.out.println("비만도: " + this.bmi);
            System.out.print("비만등급: ");
            switch (this.level) {
                case 1:
                    System.out.println("Underweight");
                    break;
                case 2:
                    System.out.println("Healthy Weight");
                    break;
                case 3:
                    System.out.println("Overweight");
                    break;
                case 4:
                    System.out.println("Obesity");
                    break;
                default:
                    System.out.println("Unknown");
            }
        }
    }

    void J055() {
        BMICalculator bmiCalculator = new BMICalculator();
        bmiCalculator.getHW();
        bmiCalculator.printBMI();
    }


}

