package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
            System.out.println("Пешеходы по лужам");
            System.out.println("А вода по асфальту рекой");
        } else {
            if (position == 2) {
                System.out.println("Спят усталые игрушки");
                System.out.println("Книжки спят");
                System.out.println("Одеяла и подушки");
                System.out.println("Ждут ребят");
            } else {
                System.out.println("Песня не найдена");
            }
        }
    }

    public static void main (String[] args) {
        Jukebox pos = new Jukebox();
        pos.music (1);
        pos.music (3);
        pos.music (2);
    }
}
