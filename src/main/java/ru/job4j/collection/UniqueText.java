package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    @SuppressWarnings("checkstyle:SimplifyBooleanExpression")
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        /* for-each origin -> new HashSet. */
        for (String word : origin) {
            check.add(word);
        }
        /* for-each text -> hashSet.contains */
        for (String word : text) {
            if (!check.contains(word)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}