package challenge01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int INPUT_LINES = sc.nextInt();

        List<Integer> numbers = getNumbers(sc, INPUT_LINES);
        printSortedNumbers(numbers);

        sc.close();
    }

    private static void printSortedNumbers(List<Integer> numbers) {
        numbers.stream().filter(n -> n % 2 == 0).sorted().forEach(System.out::println);
        numbers.stream().filter(n -> n % 2 != 0).sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static List<Integer> getNumbers(Scanner sc, final int INPUT_LINES) {
        if (!isAValidInputLines(INPUT_LINES))
            throw new IllegalArgumentException("Input lines must be within the range: 1 < N <= 10^5");

        int number;
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < INPUT_LINES; i++) {
            number = sc.nextInt();
            if (!isAValidNumber(number))
                i--;
            else
                numbers.add(number);
        }
        return numbers;
    }

    private static boolean isAValidNumber(int number) {
        return number >= 0;
    }

    private static boolean isAValidInputLines(int INPUT_LINES) {
        return INPUT_LINES > 1 && INPUT_LINES <= Math.pow(10, 5);
    }
}
