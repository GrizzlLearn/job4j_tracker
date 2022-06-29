package ru.job4j.bank;

import java.util.Objects;

public class Account {

    /**
     * Поле реквизиты аккаунта
     */
    private String requisite;

    /**
     * поле баланс аккаунта
     */
    private double balance;

    /**
     * Конструктор - создание нового объекта типа Account
     * @param requisite {@link Account#requisite}
     * @param balance {@link Account#balance}
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод возвращает значение поля {@link Account#requisite}
     * @return возвращает реквизиты аккаунта
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод задаёт значение поля {@link Account#requisite}
     * @param requisite {@link Account#requisite}
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращает значение поля {@link Account#balance}
     * @return возвращает значение баланса аккаунта
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод задаёт значение поля {@link Account#balance}
     * @param balance {@link Account#balance}
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
