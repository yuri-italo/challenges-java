package challenge02;

import java.util.*;

public class Main {
    private static final List<Integer> BILLS = Arrays.asList(100, 50, 20, 10, 5, 2);
    private static final List<Double> COINS = Arrays.asList(1d, 0.50d, 0.25d, 0.10d, 0.05d, 0.01d);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> billsQuantity = new HashMap<>();
        Map<Double,Integer> coinsQuantity = new HashMap<>();

        double remaining = sc.nextDouble();

        for (int bill : BILLS) {
            int billQuantity = getBillQuantity(billsQuantity, remaining, bill);
            remaining = getRemaining(remaining, bill, billQuantity);
        }

        for (double coin : COINS) {
            int coinQuantity = getCoinQuantity(coinsQuantity, remaining, coin);
            remaining = getRemaining(remaining, coin, coinQuantity);
        }

        printResult(billsQuantity, coinsQuantity);
        sc.close();
    }

    private static double getRemaining(double remaining, double coin, int coinQuantity) {
        remaining -= coin * coinQuantity;
        return remaining;
    }

    private static double getRemaining(double remaining, int bill, int billQuantity) {
        remaining -= bill * billQuantity;
        return remaining;
    }

    private static int getBillQuantity(Map<Integer, Integer> billsQuantity, double remaining, int bill) {
        int billQuantity = (int) (remaining / bill);
        billsQuantity.put(bill,billQuantity);
        return billQuantity;
    }

    private static int getCoinQuantity(Map<Double, Integer> coinsQuantity, double remaining, double coin) {
        int coinQuantity = (int) (remaining / coin);
        coinsQuantity.put(coin,coinQuantity);
        return coinQuantity;
    }

    private static void printResult(Map<Integer, Integer> billsQuantity, Map<Double, Integer> coinsQuantity) {
        System.out.println("NOTAS:");
        BILLS.forEach(bill -> System.out.println(billsQuantity.get(bill) + " nota(s) de R$ " + bill + ".00"));
        System.out.println("MOEDAS:");
        COINS.forEach(coin -> System.out.println(coinsQuantity.get(coin) + " moedas(s) de R$ " + String.format("%.2f",coin)));
    }
}
