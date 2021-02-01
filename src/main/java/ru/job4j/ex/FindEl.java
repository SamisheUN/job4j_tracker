package ru.job4j.ex;

public class FindEl {
    public static int indexOf (String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                rsl = index;
                break;
            }
        }
        if (rsl < 0) {
            throw new ElementNotFoundException("Нет такого элемента.");
        }
        return rsl;

    }

    public static void main(String[] args){
        String[] arrayOfLetters = new String[] {"a", "b", "c"};
        try {
            System.out.println("индекс \"а\": " + Integer.toString(indexOf(arrayOfLetters, "a")));
            System.out.println("индекс \"c\": " + Integer.toString(indexOf(arrayOfLetters, "c")));
            System.out.println("индекс \"no one\": " + Integer.toString(indexOf(arrayOfLetters, "no one")));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

    }
}
