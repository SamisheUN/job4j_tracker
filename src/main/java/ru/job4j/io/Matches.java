package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pool = 11;
        boolean first = false;
        int player = new Random().nextInt(2); //жребий первого хода 1/0
        while (pool > 0) {
            System.out.println("На столе " + pool + " спичек.");
            System.out.println("Число от игрока " + player + ": ");
            int select = Integer.valueOf(input.nextLine());
            if (select < 4 && select > 0) {          //проверка вводного числа
                pool = pool - select;
                player = player == 1 ? 0 : 1;
            } else {
                System.out.println("Некорректный ввод");
            }
        }
        player = player == 1 ? 0 : 1;
        System.out.println("Победитель: Игрок " + player);
    }
}
