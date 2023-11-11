package ru.job4j.tracker;

/**
 * Интерфейс вывода данных в консоль
 * @author Evgenii Maslakov
 * @version 1.0
 */
public interface Output {
    /**
     * Метод вывода данных в консоль
     * @param obj данные, которые выводятся на консоль
     */
    void println(Object obj);
}
