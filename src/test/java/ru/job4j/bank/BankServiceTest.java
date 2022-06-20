package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434"), is(user));
    }

    @Test
    public void deleteUser() {
        User user1 = new User("3434", "Petr Arsentev");
        User user2 = new User("5656", "Ivan Ivanov");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addUser(user2);
        bank.deleteUser(user2);
        assertNull(bank.findByPassport("5656"));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertNull(bank.findByRequisite("34", "5546"));
    }

    @Test
    public void whenEnterValidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByPassport("3434").getUsername(), is("Petr Arsentev"));
        assertThat(bank.findByRequisite("3434", "5546").getRequisite(), is("5546"));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").getBalance(), is(150D));
    }

    @Test
    public void deleteAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("5547", 250D));
        assertThat(bank.findByRequisite("3434", "5547").getBalance(), is(250D));
        bank.deleteAccount(user.getPassport(), "5547");
        assertNull(bank.findByRequisite("3434", "5547"));
    }

    @Test
    public void add2Accounts() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("1111", 150D));
        bank.addAccount(user.getPassport(), new Account("1122", 300D));
        assertThat(bank.findByRequisite("3434", "1122").getBalance(), is(300D));
    }

    @Test
    public void transferMoneyReturnTrue() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        assertTrue(bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D));
    }

    @Test
    public void transferMoneyReturnFalse() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        assertFalse(bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 250D));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "5546").getBalance(), is(0D));
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance(), is(200D));
    }

    @Test
    public void transferMoney2Users() {
        User user1 = new User("3434", "Petr Arsentev");
        User user2 = new User("5656", "Ivan Ivanov");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccount(user1.getPassport(), new Account("5546", 150D));
        bank.addAccount(user2.getPassport(), new Account("113", 50D));
        bank.transferMoney(user1.getPassport(), "5546", user2.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user1.getPassport(), "5546").getBalance(), is(0D));
        assertThat(bank.findByRequisite(user2.getPassport(), "113").getBalance(), is(200D));
    }
}
