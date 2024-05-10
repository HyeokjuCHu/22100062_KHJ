package week10;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();
        pStudio.J052();
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

            public Score(int count) {
                this.count = count;
                jumsu = new int[count][3]; // 5명의 학생, 각 학생당 3과목의 점수
                sum_student = new int[count]; // 각 학생별 총점
                average_student = new double[count]; // 각 학생별 평균
                sum_subject = new int[3]; // 국어, 영어, 수학 총점
                average_subject = new double[3]; // 국어, 영어, 수학 평균
            }

            public void getScore() {
                Scanner scanner = new Scanner(System.in);
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + "번째 학생의 국어, 영어, 수학 점수를 입력하세요: ");
                    for (int j = 0; j < 3; j++) {
                        jumsu[i][j] = scanner.nextInt();
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

                // 각 과목별 총점과 평균 출력
                System.out.println("국어 총점: " + sum_subject[0] + ", 평균: " + average_subject[0]);
                System.out.println("영어 총점: " + sum_subject[1] + ", 평균: " + average_subject[1]);
                System.out.println("수학 총점: " + sum_subject[2] + ", 평균: " + average_subject[2]);

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
        }

        void J052() {
            Score score = new Score(5); // 5명의 학생을 다룰 수 있는 Score 객체 생성
            score.getScore(); // 학생들의 점수 입력
            score.printScore(); // 학생들의 점수 출력
        }



}

