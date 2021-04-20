package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {
    @Override
    public int compare(Job ob1, Job ob2) {
        return ob2.getName().compareTo(ob1.getName());
    }
}