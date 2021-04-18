package ru.job4j.collection;

import java.util.Comparator;

//по имени и по возрастанию длины имени

public class JobSortByNameAndAscndNameLngth implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        int rsl = CharSequence.compare(o1.getName(), o2.getName());
        if (rsl == 0) {
            rsl = Integer.compare(o1.getName().length(), o2.getName().length());
        }
        return rsl;
    }
}