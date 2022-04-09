package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user: users.keySet()) {
            if (user.getPassport().equals(passport))
            rsl = user;
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        if (user != null) {
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAaccount = findByRequisite(srcPassport, srcRequisite);
        Account destAaccount = findByRequisite(destPassport, destRequisite);
        if (srcAaccount != null && destAaccount != null && srcAaccount.getBalance() >= amount) {
            rsl = true;
            srcAaccount.setBalance(srcAaccount.getBalance() - amount);
            destAaccount.setBalance(destAaccount.getBalance() - amount);
        }
        return rsl;
    }
}