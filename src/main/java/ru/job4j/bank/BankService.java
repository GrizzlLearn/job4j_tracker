package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        } else {
            System.out.println(user.getUsername() + " is already exist!");
        }
    }

    public void deleteUser(User user) {
        if (users.containsKey(user)) {
            users.remove(user);
        } else {
            System.out.println(user.getUsername() + " is not exist1");
        }
    }

    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) == null) {
            System.out.println("no have user");
        }
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getValue().add(account);
                break;
            }
        }
    }

    public void deleteAccount(String passport, String requisite) {
        if (findByPassport(passport) == null) {
            System.out.println("no have user");
        }
        User user = findByPassport(passport);
        for (int i = 0; i < users.get(user).size(); i++) {
            if (users.get(user).get(i).getRequisite().equals(requisite)) {
                users.get(user).remove(i);
            }
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                rsl = entry.getKey();
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        if (findByPassport(passport) == null) {
            return rsl;
        }

        User user = findByPassport(passport);
        for (int i = 0; i < users.get(user).size(); i++) {
            if (users.get(user).get(i).getRequisite().equals(requisite)) {
                rsl = users.get(user).get(i);
            }
        }

        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        if (findByPassport(srcPassport) != null
                && findByRequisite(srcPassport, srcRequisite) != null
                && findByPassport(destPassport) != null
                && findByRequisite(destPassport, destRequisite) != null
                && amount > 0) {
            Account src = findByRequisite(srcPassport, srcRequisite);
            Account dest = findByRequisite(destPassport, destRequisite);
            if (src.getBalance() >= amount) {
                src.setBalance(src.getBalance() - amount);
                dest.setBalance(dest.getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}
