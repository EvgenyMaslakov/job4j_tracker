package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета пользователя
 * @author EVGENY MASLAKOV
 * @version 1.0
 */
public class Account {

    /**
     * Поле хранит номер банковского счета
     */
    private String requisite;
    /**
     * Поле хранит баланс на банковском счете
     */
    private double balance;

    /**
     * Конструктор служит для создания аккаунта пользователя.
     * Принимает на вход номер банковского счета и баланс на этом счете
     * @param requisite номер банковского счета
     * @param balance баланс на этом счете
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод служит для получения номера банковского счета пользователя
     * @return возвращает номер банковского счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод служит для изменения номера банковского счета пользователя
     * @param requisite новый номер банковского счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод служит для получения баланса на банковском счете
     * @return возвращает баланс банковского счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод служит для изменения баланса на банковском счете пользователя
     * @param balance новый баланс банковского счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод служит для проверки равенства объекта вызвавшего данный метод
     * и объекта, который поступает в параметрах.
     * Сначала мы сравниваем ссылки
     * Если две переменные ссылаются на один блок памяти, то объекты будут однозначно равны.
     * Проверяем, что аргумент метода не равен null.
     * Если он равен, то объекты не равны. Это элемент валидации.
     * Проверяем типы классов.
     * Объекты могут быть равны, только если классы моделей одинаковые.
     * Сравниваем поля.
     * Если поля равны, то два объекта равны тоже.
     * Для ссылочного типа Object используется метод equals.
     * @param o объект, который будет сравниваться с текущим объектом
     * @return возвращает результат сравнения либо true, либо false
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
     * Метод служит для проверки равенства объектов по хэш-коду
     * @return возвращает 32-битное число типа int
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
