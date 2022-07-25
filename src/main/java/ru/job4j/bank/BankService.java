package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;

/**
 * Класс описывает простейшую логику работы банковского приложения
 * @author Dmitry Lebedev
 * @version 1.0
 */

public class BankService {

    /**
     * Пары(ключ - значение) {@code User} и {@code List<Account>} хранятся в коллекции типа {@code HashMap}
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя {@link User} в коллекцию (если его ещё нет) с пустым списком аккаунтов
     * @param user пользователь, который добавляется в коллекцию
     * @see User#User(String, String)
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя {@link User} из коллекции.
     * @param user пользователь, который удаляется из коллекции
     * @see User#User(String, String)
     */
    public void deleteUser(User user) {
        users.remove(user);
    }

    /**
     * Метод добавляет аккаунт {@link Account} пользователю {@link User} если он найден.
     * @param passport объект типа String, по нему ищется пользователь
     * @param account объект типа Account, который добавляется пользователю
     * @see Account#Account(String, double)
     * @see User#User(String, String)
     * @see BankService#findByPassport(String)
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }

    /**
     * Метод производит поиск и удаление аккаунта пользователя если он найден.
     * @param passport объект типа String, по нему ищется пользователь
     * @param requisite объект типа String, по нему ищется аккаунт пользователя
     * @see User#User(String, String)
     * @see Account#Account(String, double)
     * @see BankService#findByPassport(String)
     */
    public void deleteAccount(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            users.get(user).remove(new Account(requisite, 0));
        }
    }

    /**
     * Метод производит поиск User по паспорту.
     * Возвращает {@code null} если пользователь не найден.
     * @param passport объект типа String, по нему ищется пользователь
     * @return {@code User}, если пользователь найден
     * @see User#User(String, String)
     * @see User#getPassport()
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(p -> p.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод производит поиск аккаунта пользователя по паспорту и реквизитам аккаунта.
     * Возвращает {@code null} если не найден пользователь или аккаунт.
     * @param passport объект типа String, по нему ищется пользователь
     * @param requisite объект типа String, по нему ищется аккаунт пользователя
     * @return {@code Account}, если аккаунт найден
     * @see BankService#findByPassport(String)
     * @see Account#getRequisite()
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account result = null;
        if (user != null) {
            result = users.get(user).stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return result;
    }

    /**
     * Метод производит перевод денег между аккаунтами одного пользователя или двух разных пользователей.
     * Возвращает {@code true} если перевод средств произведен успешно.
     * Возвращает {@code false} если акканты не найдены по реквизитам или недостаточно средств для перевода.
     * @param srcPassport объект типа String, по нему ищется пользователь, который производит перевод.
     * @param srcRequisite объект типа String, по нему ищется аккаунт пользователя, с которого производится списание.
     * @param destPassport объект типа String, по нему ищется пользователь, которому производится перевод.
     * @param destRequisite объект типа String, по нему ищется аккаунт пользователя, на который производится начисление.
     * @param amount объект типа double, должен быть меньше и равен балансу {@code srcRequisite}.
     * @return {@code true}, если перевод средств произведен успешно
     * @see BankService#findByRequisite(String, String)
     * @see Account#getBalance()
     * @see Account#setBalance(double)
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;

        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);

        if (src != null && dest != null && src.getBalance() >= amount) {
                src.setBalance(src.getBalance() - amount);
                dest.setBalance(dest.getBalance() + amount);
                rsl = true;
        }
        return rsl;
    }
}
