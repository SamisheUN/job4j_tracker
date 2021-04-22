package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает объект упрощённо имитирующий клиента банка.
 *
 * @author A.S.
 * @version 0
 */
public class User implements Comparable<User> {
    /**
     * Поле содержит паспорт клиента.
     */
    private String passport;
    /**
     * Поле содержит имя клиента.
     */
    private String username;
    /**
     * Поле содержит возвраст клиента.
     */
    private int age;

    /**
     * Конструктор объекта, предназначен для директории bank.
     *
     * @param passport паспорт.
     * @param username имя.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Конструктор объекта, предназначен для одного из сторонних заданий,
     * перегружен, т.к. замена/удаление влекли ошибки.
     *
     * @param username имя
     * @param age      возраст
     */
    public User(String username, int age) {
        this.age = age;
        this.username = username;
    }

    /**
     * геттер для passport
     * @return паспорт объекта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * сеттер для passport, присваивает паспорт клиенту
     * @param passport паспорт
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * геттер для username
     * @return возвращает имя клиента
     */
    public String getUsername() {
        return username;
    }

    /**
     * сеттер для username, для именования клиента
     * @param username имя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * геттер для age клиента,
     * @return возвращает возраст
     */
    public int getAge() {
        return age;
    }

    /**
     * сеттер для возраста клиента
     * @param age возраст
     */
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

    /**
     * Метод, сравнивающий объекты User.
     * При сравнении учитываются age и username.
     * @param o объект типа User.
     * @return Возвращает true, учитывая при сравнении age и username.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age
                &&
                Objects.equals(username, user.username);
    }

    /**
     * Вычисление hash кода.
     *
     * @return Возвращает hash объекта по совокупности параметров username и age.
     */
    @Override
    public int hashCode() {
        return Objects.hash(username, age);
    }

    /**
     * Метод нахождения порядка следования объектов, учитывая в первую очередь username, затем age.
     * @param another принимает объект типа User.
     * @return возвращает 0 в случае идентичных username и age.
     * Возвращает отрицательное целое число,
     * в случае когда username объекта лексикографически предшествует username аргумента,
     * либо, в случае когда, при равных username, age объекта меньше age аргумента.
     * Возвращает положительное целое число,
     * в случае когда username аргумента лексикографически предшествует username объекта,
     * либо, в случае когда, при равных username, age аргумента меньше age объекта.
     */
    @Override
    public int compareTo(User another) {
        int rsl = username.compareTo(another.getUsername());
        if (rsl == 0) {
            rsl = Integer.compare(age, another.getAge());
        }
        return rsl;
    }
}