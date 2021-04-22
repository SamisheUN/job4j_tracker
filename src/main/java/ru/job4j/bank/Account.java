package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает объект упрощённо имитирующий банковский счёт.
 *
 * @author A.S.
 * @version 0
 */
public class Account {
    /**
     * Поле содержит реквизиты счёта в виде произвольной строки.
     */
    private String requisite;
    /**
     * Поле содержит кол-во средств на счёте.
     */
    private double balance;

    /**
     * Конструктор объекта-счёта.
     *
     * @param requisite реквизиты счёта.
     * @param balance   средства на счёте.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * геттер для requisite
     *
     * @return возвращает реквизиты счёта.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * сеттер для requisite
     *
     * @param requisite присваивает счёту реквизиты.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * геттер для balance
     *
     * @return возвращает баланс счёта.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * сеттер для balance, устанавливает баланс счёта.
     *
     * @param balance баланс счёта.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод для сравнения объектов Account.
     * Сходство проверяется исключительно по параметру requisite.
     *
     * @param o Принимаемый объект для сравнения.
     * @return Возвращает true в случае идентичности объектов.
     */
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

    /**
     * Вычисление hash-кода.
     *
     * @return Возвращает hash объекта исключительно по параметру requisite.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}