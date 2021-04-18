package ru.job4j.collection;

import java.util.Comparator;

//по имени и по убыванию длины имени

public class JobSortByNameAndDscndNameLngth implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        int rsl = CharSequence.compare(o1.getName(), o2.getName());
        if (rsl == 0) {
            rsl = Integer.compare(o2.getName().length(), o1.getName().length());
        }
        return rsl;
    }
}