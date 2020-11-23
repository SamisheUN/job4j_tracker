package ru.job4j.oop;
/*
1. Создать класс ru.job4j.oop.Battery. в нем должно быть поле private int load.

2. Создать метод public void exchange(Battery another). Этот метод должен списывать заряд из батареи
у кого вызывали метод exchange и добавить к объекту another.
 */

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load = this.load + another.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(50);
        Battery second = new Battery(12);

        System.out.println("1st load:" + first.load);
        System.out.println("2nd load:" + second.load);
        first.exchange(second);
        System.out.println("1st after exchange:" + first.load);
        System.out.println("2nd after exchange:" + second.load);
    }

}
