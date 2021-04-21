package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Передвигается по автомобильным дорогам.");
    }

    @Override
    public void fuel() {
        System.out.println("Бензин");
    }
}
