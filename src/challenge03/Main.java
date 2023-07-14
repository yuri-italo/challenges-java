package challenge03;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = createArray(sc, arraySize);
        Set<Integer> differentNumbers = getDifferentNumbers(arr);
        int count = getCount(target, arr, differentNumbers);

        System.out.println(count);
        sc.close();
    }

    private static int[] createArray(Scanner sc, int arraySize) {
        int[] arr = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    private static Set<Integer> getDifferentNumbers(int[] arr) {
        Set<Integer> differentNumbers = new HashSet<>();

        for (int number : arr) {
            differentNumbers.add(number);
        }

        return differentNumbers;
    }

    private static int getCount(int target, int[] arr, Set<Integer> differentNumbers) {
        int count = 0;

        for (int number : arr) {
            if (differentNumbers.contains(number + target))
                count++;
        }

        return count;
    }
}
