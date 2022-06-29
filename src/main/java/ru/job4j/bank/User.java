package ru.job4j.bank;

import java.util.Objects;

public class User {

    /**
     * Поле паспорт пользователя
     */
    private String passport;

    /**
     * Поле имя пользователя
     */
    private String username;

    /**
     * Конструктор passport создание нового объекта типа User
     * @param passport {@link User#passport}
     * @param username {@link User#username}
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает значение поля {@link User#passport}
     * @return возвращает паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод задаёт значение поля {@link User#passport}
     * @param passport {@link User#passport}
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает значение поля {@link User#username}
     * @return возвращает имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод задаёт значение поля {@link User#username}
     * @param username {@link User#username}
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
