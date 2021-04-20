package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByPriority implements Comparator<Job> {
    @Override
    public int compare(Job ob1, Job ob2) {
        return Integer.compare(ob2.getPriority(), ob1.getPriority());
    }
}