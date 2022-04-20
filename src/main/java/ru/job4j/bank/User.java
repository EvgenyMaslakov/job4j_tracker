package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка
 * @author EVGENY MASLAKOV
 * @version 1.0
 */
public class User {

    /**
     * Поле хранит номер паспорта пользователя банка
     */
    private String passport;
    /**
     * Поле хранит ФИО пользователя банка
     */
    private String username;

    /**
     * Конструктор служит для создания в банковской системе пользователя.
     * Принимает на вход номер паспорта и ФИО пользователя.
     * @param passport номер паспорта пользователя
     * @param username ФИО пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод служит для получения номера паспорта пользователя.
     * @return возвращает номера паспорта пользователя.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод служит для изменения номера паспорта пользователя
     * @param passport новый номер паспорта пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод служит для получения ФИО пользователя.
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод служит для изменения ФИО пользователя
     * @param username новые ФИО пользователя
     */
    public void setUsername(String username) {
        this.username = username;
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод служит для проверки равенства объектов по хэш-коду
     * @return возвращает 32-битное число типа int
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
