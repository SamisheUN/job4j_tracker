package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) {
        int rsl;
        if (n == 0 || n == 1) {
            return 1;
        }
        return calc(n - 1) * n;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println("i=" + i);
            int rsl = calc(i);
            System.out.println(rsl);
        }

    }
}