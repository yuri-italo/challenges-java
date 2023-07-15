package challenge04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> lines = getLines(sc);
        decipherLines(lines);
        sc.close();
    }

    private static List<String> getLines(Scanner sc) {
        final int INPUT_LINES = sc.nextInt();
        sc.nextLine();

        List<String> lines = new ArrayList<>();

        for (int i = 0; i < INPUT_LINES; i++) {
            lines.add(sc.nextLine());
        }

        return lines;
    }

    private static void decipherLines(List<String> lines) {
        for (String line : lines) {
            String firstPart = getFirstPart(line);
            printFirstPart(firstPart);
            String secondPart = getSecondPart(line);
            printSecondPart(secondPart);
        }
    }

    private static String getFirstPart(String line) {
        int beginIndex = 0;
        int endIndex = line.length() / 2;
        return line.substring(beginIndex, endIndex);
    }

    private static String getSecondPart(String line) {
        int beginIndex = line.length() / 2;
        return line.substring(beginIndex);
    }

    private static void printFirstPart(String firstPart) {
        int beginIndex = firstPart.length() - 1;
        for (int i = beginIndex; i >= 0; i--) {
            System.out.print(firstPart.charAt(i));
        }
    }

    private static void printSecondPart(String secondPart) {
        int beginIndex = secondPart.length() - 1;
        for (int i = beginIndex; i >= 0; i--) {
            System.out.print(secondPart.charAt(i));
        }
        System.out.println();
    }
}
