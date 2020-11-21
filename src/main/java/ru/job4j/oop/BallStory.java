package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball kolobock = new Ball();
        Hare hare = new Hare();
        Fox fox = new Fox();
        Wolf wolf = new Wolf();
        hare.tryEat(kolobock);
        wolf.tryEat(kolobock);
        fox.tryEat(kolobock);
        kolobock.trySurvive(kolobock);
    }
}
