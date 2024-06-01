package week13;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        week13.Main pStudio = new week13.Main();
        pStudio.J085();
    }

    void J081() {
        String data = "";
        String filePath = "C:\\권혁주\\PS\\Java_DS\\22100062_KHJ\\src\\week13\\j081.txt";

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath))) {
            StringBuilder sb = new StringBuilder();
            int i;
            while ((i = bufferedInputStream.read()) != -1) {
                sb.append((char) i);
            }
            data = sb.toString();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Text file content: " + data);

        String[] arrayData = data.trim().split("\\s+");
        int[] arrayDataInt = new int[arrayData.length];
        for (int i = 0; i < arrayData.length; i++) {
            try {
                arrayDataInt[i] = Integer.parseInt(arrayData[i]);
            } catch (NumberFormatException e) {
                System.out.println("Error parsing integer: " + e.getMessage());
                return; // Exit if there is a parsing error
            }
        }

        int max = arrayDataInt[0];
        int min = arrayDataInt[0];
        for (int i = 1; i < arrayDataInt.length; i++) {
            if (arrayDataInt[i] > max) {
                max = arrayDataInt[i];
            }
            if (arrayDataInt[i] < min) {
                min = arrayDataInt[i];
            }
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    void J082() {
        List<String> dataList = new ArrayList<>();
        String filePath = "C:\\권혁주\\PS\\Java_DS\\22100062_KHJ\\src\\week13\\j082.txt";

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String each = scanner.nextLine();
                dataList.add(each);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        System.out.println(dataList);
        for (String each : dataList) {
            String[] arrayHW = each.split(" ");
            try {
                int height = Integer.parseInt(arrayHW[0]);
                int weight = Integer.parseInt(arrayHW[1]);

                double bmi = weight / (height * 0.01 * height * 0.01);
                System.out.println(bmi);
                if (bmi >= 25) {
                    System.out.println("!!! : " + bmi + "// height : " + height + "// weight : " + weight);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error parsing integer: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Incorrect format in file - " + e.getMessage());
            }
        }
    }

    class Score {
        private String name;
        private int kor, eng, mat;
        private int sum;
        private double avg;

        public Score(String name, int kor, int eng, int mat) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.mat = mat;
            this.sum = kor + eng + mat;
            this.avg = sum / 3.0;
        }

        // Getters
        public String getName() {
            return name;
        }

        public int getKor() {
            return kor;
        }

        public int getEng() {
            return eng;
        }

        public int getMat() {
            return mat;
        }

        public int getSum() {
            return sum;
        }

        public double getAvg() {
            return avg;
        }

        @Override
        public String toString() {
            return name + " - Kor: " + kor + ", Eng: " + eng + ", Mat: " + mat + ", Sum: " + sum + ", Avg: " + avg;
        }
    }


    class ScoreManager {
        private List<Score> scores;

        public ScoreManager() {
            scores = new ArrayList<>();
        }

        public void addScore(Score score) {
            scores.add(score);
        }

        public void printSubjectTotalsAndAverages() {
            int totalKor = 0, totalEng = 0, totalMat = 0;
            for (Score score : scores) {
                totalKor += score.getKor();
                totalEng += score.getEng();
                totalMat += score.getMat();
            }

            int numStudents = scores.size();
            System.out.println("Korean Total: " + totalKor + ", Average: " + (totalKor / (double)numStudents));
            System.out.println("English Total: " + totalEng + ", Average: " + (totalEng / (double)numStudents));
            System.out.println("Math Total: " + totalMat + ", Average: " + (totalMat / (double)numStudents));
        }

        public void printStudentTotalsAndAverages() {
            for (Score score : scores) {
                System.out.println(score);
            }
        }

        public void printTopStudent() {
            Score topStudent = null;
            for (Score score : scores) {
                if (topStudent == null || score.getAvg() > topStudent.getAvg()) {
                    topStudent = score;
                }
            }

            if (topStudent != null) {
                System.out.println("Top Student: " + topStudent.getName() + " - Avg: " + topStudent.getAvg());
            }
        }
    }


    void J083() {
        ScoreManager manager = new ScoreManager();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\권혁주\\PS\\Java_DS\\22100062_KHJ\\src\\week13\\j083.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                int kor = Integer.parseInt(parts[1]);
                int eng = Integer.parseInt(parts[2]);
                int mat = Integer.parseInt(parts[3]);
                Score score = new Score(name, kor, eng, mat);
                manager.addScore(score);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("1) 각 과목별 총점과 평균 점수");
        manager.printSubjectTotalsAndAverages();

        System.out.println("\n2) 각 학생별 총점과 평균 점수");
        manager.printStudentTotalsAndAverages();

        System.out.println("\n3) 가장 높은 평균 점수를 받은 학생의 이름과 점수");
        manager.printTopStudent();
    }

    void J084() {
        String fileName = "C:\\권혁주\\PS\\Java_DS\\22100062_KHJ\\src\\week13\\name.txt";
        int count = 0;
        String longestName = "";
        String shortestName = null;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                count++;
                if (shortestName == null || line.length() < shortestName.length()) {
                    shortestName = line;
                }
                if (line.length() > longestName.length()) {
                    longestName = line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Count: " + count);
        System.out.println("Longest name: " + longestName);
        System.out.println("Shortest name: " + shortestName);
    }

    void J085() {
        String data = getText("C:\\권혁주\\PS\\Java_DS\\22100062_KHJ\\src\\week13\\j085.txt");
        System.out.println("text file: " + data);

        int[] arrayNum = {0, 0, 0, 0}; //숫자, 대, 소, 빈칸

        for (int i = 0; i < data.length(); i++) {
            char each = data.charAt(i);
            if (each >= '0' && each <= '9') {
                //숫자
                arrayNum[0]++;
            } else if (each >= 'A' && each <= 'Z') {
                //대문자
                arrayNum[1]++;
            } else if (each >= 'a' && each <= 'z') {
                //소문자
                arrayNum[2]++;
            } else if (each == ' ') {
                //공백
                arrayNum[3]++;
            }
        }

        System.out.println("A-Z - " + arrayNum[1]);
        System.out.println("a-z - " + arrayNum[2]);
        System.out.println("spaces - " + arrayNum[3]);

    }

    String getText(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}


