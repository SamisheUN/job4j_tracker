package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int leftLength = left.length();
        int rightLength = right.length();
        int rsl = 0;
        int leftHaveMuchChars = leftLength - rightLength;
        int minLength = leftLength > rightLength ? rightLength : leftLength;
        for(int index = 0; index < minLength; index++) {
            rsl = Character.compare(left.charAt(index), right.charAt(index));
            if(rsl != 0) {
                return rsl;
            }
        }
        if (leftHaveMuchChars != 0) {
        rsl = leftHaveMuchChars > 0 ? 1 : -1;
        }
        return rsl;
    }
}