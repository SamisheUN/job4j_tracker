package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подошедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person index : persons) {
            if (
                    index.getName().contains(key) ||
                    index.getSurname().contains(key) ||
                    index.getPhone().contains(key) ||
                    index.getAddress().contains(key)
            )
                result.add(index);
        }
        return result;
    }
}