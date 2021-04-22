package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Класс описывает систему, имитирующую БД банка,
 * предназначенную для хранения информации о клиентах в формате
 * списка аккаунтов с указанием в каждом ФИО обладателя и присвоенных ему счетов.
 * @author A.S.
 * @version 0
 */
public class BankService {
    /**
     * Хранение информации осуществляется в коллекции типа Map,
     * с ключём по объекту User, и коллекцией типа List.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод предназначен для добавления в БД нового пользователя.
     * В случае если идентичный не внесён ранее, добавляет требуемого с пустым списком аккаунтов.
     * @param user объект User
     */
    public void addUser(User user) {
        List<Account> accounts = new ArrayList<Account>();
        /*if (!users.containsKey(user.getPassport())) {
            users.put(user, accounts);
        }*/
        users.putIfAbsent(user, accounts);
    }

    /**
     * Метод предназначен для добавления аккаунта существующему в БД пользователю.
     * @param passport паспорт пользователя-адресата
     * @param account аккаунт для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод предназначен для поиска по паспорту пользователя.
     * @param passport паспорт
     * @return возвращает, в случае обнаружения, объект типа User, в ином случае null.
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                rsl = key;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод предназначен для поиска аккаунта пользователя.
     * В первую очередь ищется пользователь по passport, затем по requisite искомый аккаунт.
     * @param passport паспорт
     * @param requisite реквизиты аккаунта
     * @return возвращает, в случае обнаружения, объект типа Account, в ином случае null.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccs = users.get(user);
            for (Account acc : userAccs) {
                if (acc.getRequisite().equals(requisite)) {
                    rsl = acc;
                    //int index = userAccs.indexOf(new Account(requisite, -1));
                    //rsl = userAccs.get(index);
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод предназначен для перевода валюты с одного аккаунта на другой.
     * Проверяется существование обоих аккаунтов,
     * затем возможность вычета указанного объёма валюты с аккаунты-донора.
     * @param srcPassport паспорт донора
     * @param srcRequisite реквизиты аккаунта донора
     * @param destPassport паспорт реципиента
     * @param destRequisite реквизиты аккаунта реципиента
     * @param amount сумма перевода
     * @return в случае успешного перевода возвращает true, в ином случае - false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl;
        Account sourceAcc = findByRequisite(srcPassport, srcRequisite);
        Account destinationAcc = findByRequisite(destPassport, destRequisite);
        if (sourceAcc == null || sourceAcc.getBalance() < amount || destinationAcc == null) {
            return false;
        }
        sourceAcc.setBalance(sourceAcc.getBalance() - amount);
        destinationAcc.setBalance((destinationAcc.getBalance() + amount));
        rsl = true;
        return rsl;
    }
}