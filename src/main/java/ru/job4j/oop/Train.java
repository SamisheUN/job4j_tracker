package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Передвигается по железнодорожным путям.");
    }

    @Override
    public void fuel() {
        System.out.println("Дизельное топливо");
    }
}
