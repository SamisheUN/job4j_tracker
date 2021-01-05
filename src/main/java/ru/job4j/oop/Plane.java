package ru.job4j.oop;

public class Plane implements Vehicle{
    @Override
    public void move() {
        System.out.println("Летает в атмосфере.");
    }

    @Override
    public void fuel() {
        System.out.println("Керосин");
    }
}
