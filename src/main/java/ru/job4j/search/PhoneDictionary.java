package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();

        for (Person person : persons) {
            if (key.equals(person.getName())
                    || key.equals(person.getSurname())
                    || key.equals(person.getPhone())
                    || key.equals(person.getAddress())) {
                result.add(person);
            }
        }
        return result;
    }
}
