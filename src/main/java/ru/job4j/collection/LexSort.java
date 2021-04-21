package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    public int digitsextractor (String word) {
        String digit = new String();
        for(int index = 0; index < word.length(); index++){
            if (Character.isDigit((word.charAt(index)))) {
                digit = digit + word.charAt(index);
            } else {
                break;
            }
        }
        return Integer.parseInt(digit);
    }

    @Override
    public int compare(String left, String right) {
        return Integer.compare(digitsextractor(left), digitsextractor(right));
    }
}