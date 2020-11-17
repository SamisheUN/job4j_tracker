package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;

    public void show() { //метод вывода еды
        System.out.println(this.name);
        System.out.println(this.food);
    }

    public void giveNick (String nick) {
        this.name = nick;
    }

    public void eat (String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's name an food.");
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNick("Gav");
        gav.show();
        System.out.println("There are black's name an food.");
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Black");
        black.show();
    }
}
