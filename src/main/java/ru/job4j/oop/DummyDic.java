package ru.job4j.oop;

public class DummyDic {
    public static void main(String[] args) { //проверка вывода на практике
        DummyDic testWord = new DummyDic();
        System.out.println(testWord.engToRus("bo"));
        System.out.println(testWord.engToRus("gne"));
    }

    public String engToRus(String end) {
        String phrase = end + "eng";
        return phrase;
    }
}
