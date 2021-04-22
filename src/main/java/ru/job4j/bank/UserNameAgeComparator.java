package ru.job4j.bank;

import java.util.Comparator;

/**
 * Класс содержит компаратор для объектов типа User
 * @see User *
 * @author A.S.
 * @version 0
 */
public class UserNameAgeComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.compareTo(o2);
    }
}
