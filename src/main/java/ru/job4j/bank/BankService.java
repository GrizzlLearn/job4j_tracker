package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        if (!users.containsKey(user)) {
            System.out.println(user.getUsername() + " is not exist!");
        } else {
            users.remove(user);
        }
    }

    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) == null) {
            System.out.println("no have user");
        } else {
            users.get(findByPassport(passport)).add(account);
        }
    }

    public void deleteAccount(String passport, String requisite) {
        if (findByPassport(passport) == null) {
            System.out.println("no have user");
        }
        User user = findByPassport(passport);
        for (Account acc : users.get(user)) {
            if (acc.getRequisite().equals(requisite)) {
                users.get(user).remove(acc);
                break;
            }
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        if ("".equals(passport)) {
            return null;
        }
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        if (findByPassport(passport) == null) {
            return null;
        }

        User user = findByPassport(passport);
        for (Account acc : users.get(user)) {
            if (acc.getRequisite().equals(requisite)) {
                rsl = acc;
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        if (findByRequisite(srcPassport, srcRequisite) == null
                || findByRequisite(destPassport, destRequisite) == null
                || amount < 0) {
            return rsl;
        }

        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);

        if (src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
