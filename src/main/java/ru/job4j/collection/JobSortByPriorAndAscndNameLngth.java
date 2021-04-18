package ru.job4j.collection;

import java.util.Comparator;

public class JobSortByPriorAndAscndNameLngth implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        int rsl = Integer.compare(o1.getPriority(), o2.getPriority());
        if (rsl == 0) {
            rsl = CharSequence.compare(o1.getName(), o2.getName());
        }
        return rsl;
    }
}