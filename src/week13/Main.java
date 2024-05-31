package week13;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        week13.Main pStudio = new week13.Main();
        pStudio.J082();
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

}


