package ru.job4j.tracker;

/**
 * Объекты этой сущности отвечают за ввод данных.
 * Здесь используется множественное определение ввода данных, потому что
 * в системе два объекта, отвечающих за ввод данных.
 * Один для консоли, другой для тестов.
 * @author Evgenii Maslakov
 * @version 1.0
 */
public interface Input {
    String askStr(String question);

    int askInt(String question);
}
