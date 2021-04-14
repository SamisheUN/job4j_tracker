package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List <Account> accounts = new ArrayList<Account>();
        if (!users.containsKey(user.getPassport())) {
            users.put(user, accounts);
        }
    }

    public void addAccount(String passport, Account account) {
        if (findByPassport(passport) != null && !users.get(findByPassport(passport)).contains(account)) {
            users.get(findByPassport(passport)).add(account);
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)){
                rsl = key;
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List <Account> userAccs = users.get(user);
            for (Account acc : userAccs) {
                /*if (acc.getRequisite().equals(requisite)) {
                rsl = acc;
                }*/
                int index = userAccs.indexOf(new Account(requisite, -1));
                rsl = userAccs.get(index);
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account sourceAcc = findByRequisite(srcPassport, srcRequisite);
        Account destinationAcc = findByRequisite(destPassport, destRequisite);
        if (sourceAcc.getBalance() < amount || sourceAcc == null || destinationAcc == null) {
            return false;
        }
        sourceAcc.setBalance(sourceAcc.getBalance() - amount);
        destinationAcc.setBalance((destinationAcc.getBalance() + amount));
        rsl = true;
        return rsl;
    }
}