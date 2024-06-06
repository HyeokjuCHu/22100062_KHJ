package week14;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        week14.Main pStudio = new week14.Main();
        pStudio.J092();
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

        // Setters
        public void setKor(int kor) {
            this.kor = kor;
            updateSumAndAvg();
        }

        public void setEng(int eng) {
            this.eng = eng;
            updateSumAndAvg();
        }

        public void setMat(int mat) {
            this.mat = mat;
            updateSumAndAvg();
        }

        private void updateSumAndAvg() {
            this.sum = kor + eng + mat;
            this.avg = sum / 3.0;
        }

        @Override
        public String toString() {
            return name + " - Kor: " + kor + ", Eng: " + eng + ", Mat: " + mat + ", Sum: " + sum + ", Avg: " + avg;
        }
    }

    class ScoreManager {
        private Map<String, week14.Main.Score> scores;

        public ScoreManager() {
            scores = new HashMap<>();
        }

        public void addScore(week14.Main.Score score) {
            scores.put(score.getName(), score);
        }

        public void printSubjectTotalsAndAverages() {
            int totalKor = 0, totalEng = 0, totalMat = 0;
            for (week14.Main.Score score : scores.values()) {
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
            for (week14.Main.Score score : scores.values()) {
                System.out.println(score);
            }
        }

        public void printTopStudent() {
            week14.Main.Score topStudent = null;
            for (week14.Main.Score score : scores.values()) {
                if (topStudent == null || score.getAvg() > topStudent.getAvg()) {
                    topStudent = score;
                }
            }

            if (topStudent != null) {
                System.out.println("Top Student: " + topStudent.getName() + " - Avg: " + topStudent.getAvg());
            }
        }

        public void searchStudent(String name) {
            week14.Main.Score score = scores.get(name);
            if (score != null) {
                System.out.println(score);
            } else {
                System.out.println("Student not found.");
            }
        }

        public void updateStudentScore(String name, int kor, int eng, int mat) {
            week14.Main.Score score = scores.get(name);
            if (score != null) {
                score.setKor(kor);
                score.setEng(eng);
                score.setMat(mat);
                System.out.println("Updated score: " + score);
            } else {
                System.out.println("Student not found.");
            }
        }
    }

    void J091() {
        week14.Main.ScoreManager manager = new week14.Main.ScoreManager();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\권혁주\\PS\\Java_DS\\22100062_KHJ\\src\\week14\\j091.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                int kor = Integer.parseInt(parts[1]);
                int eng = Integer.parseInt(parts[2]);
                int mat = Integer.parseInt(parts[3]);
                week14.Main.Score score = new week14.Main.Score(name, kor, eng, mat);
                manager.addScore(score);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1) Print subject totals and averages");
            System.out.println("2) Print student totals and averages");
            System.out.println("3) Print top student");
            System.out.println("4) Search student");
            System.out.println("5) Update student score");
            System.out.println("6) Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    manager.printSubjectTotalsAndAverages();
                    break;
                case 2:
                    manager.printStudentTotalsAndAverages();
                    break;
                case 3:
                    manager.printTopStudent();
                    break;
                case 4:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    manager.searchStudent(name);
                    break;
                case 5:
                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new Korean score: ");
                    int kor = scanner.nextInt();
                    System.out.print("Enter new English score: ");
                    int eng = scanner.nextInt();
                    System.out.print("Enter new Math score: ");
                    int mat = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    manager.updateStudentScore(name, kor, eng, mat);
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    class ParkingInfo {
        private String carNumber;
        private String carType;
        private Date enterTime;

        public ParkingInfo(String carNumber, String carType, Date enterTime) {
            this.carNumber = carNumber;
            this.carType = carType;
            this.enterTime = enterTime;
        }

        public String getCarNumber() {
            return carNumber;
        }

        public String getCarType() {
            return carType;
        }

        public Date getEnterTime() {
            return enterTime;
        }
    }
    class ParkingLot {
        private LinkedHashMap<String, ParkingInfo> parkingMap = new LinkedHashMap<>();
        private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmm");

        public void enter(String carNumber, String carType) {
            Date now = new Date();
            ParkingInfo info = new ParkingInfo(carNumber, carType, now);
            parkingMap.put(carNumber, info);
        }

        public void exit(String carNumber) {
            ParkingInfo info = parkingMap.remove(carNumber);
            if (info != null) {
                Date now = new Date();
                long duration = now.getTime() - info.getEnterTime().getTime();
                long minutes = (duration / (1000 * 60));
                long fee = (minutes < 10) ? 0 : ((minutes / 10) + 1) * 500;

                System.out.println(info.getCarNumber() + " " + info.getCarType() + " " + minutes + "min, Parking fee " + fee + " (current time " + dateFormat.format(now) + ")");
            } else {
                System.out.println("해당 차량번호가 없습니다.");
            }
        }

        public void list() {
            if (parkingMap.isEmpty()) {
                System.out.println("주차된 차량이 없습니다.");
            } else {
                System.out.println("===================================================");
                System.out.println("num\t\t\ttype\t\ttime");
                int i = 1;
                for (ParkingInfo info : parkingMap.values()) {
                    System.out.printf("[%d]\t%s\t%s\t\t%s\n", i, info.getCarNumber(), info.getCarType(), dateFormat.format(info.getEnterTime()));
                    i++;
                }
            }
        }

        public void quit() {
            System.out.println("Bye!");
            System.exit(0);
        }
    }




    void J092(){
        ParkingLot parkingLot = new ParkingLot();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("1) enter, 2) exit, 3) list 4) quit > ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter number, type > ");
                    String carNumber = scanner.next();
                    String carType = scanner.next();
                    parkingLot.enter(carNumber, carType);
                    break;
                case 2:
                    System.out.print("Enter car number to exit > ");
                    String exitCarNumber = scanner.nextLine();
                    parkingLot.exit(exitCarNumber);
                    break;
                case 3:
                    parkingLot.list();
                    break;
                case 4:
                    parkingLot.quit();
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }
}
