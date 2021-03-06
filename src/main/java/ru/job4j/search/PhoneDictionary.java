package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

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
        Predicate<Person> byName = (p) -> p.getName().contains(key);
        Predicate<Person> bySurname = (p) -> p.getSurname().contains(key);
        Predicate<Person> byPhone = (p) -> p.getPhone().contains(key);
        Predicate<Person> byAddress = (p) -> p.getAddress().contains(key);
        var predicateCombine =  byName.or(bySurname).or(byPhone).or(byAddress);

        for (var person : persons) {
            if (predicateCombine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
