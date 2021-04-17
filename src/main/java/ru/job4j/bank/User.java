package ru.job4j.bank;

import ru.job4j.tracker.Item;

import java.util.Comparator;
import java.util.Objects;

public class User implements Comparable<User>, Comparator<User> {
    private String passport;
    private String username;
    private int age;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public User(String username, int age) {
        this.age = age;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    /* @Override //старый по паспорту
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(passport, user.passport);
        }

        @Override
        public int hashCode() {
            return Objects.hash(passport);
        }*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, age);
    }

    @Override
    public int compareTo(User another) {
        int rsl = CharSequence.compare(username, another.getUsername());
        if (rsl == 0) {
            rsl = Integer.compare(age, another.getAge());
        }
        return rsl;
    }

    @Override
    public int compare(User o1, User o2) {
        return o1.compareTo(o2);
    }
}