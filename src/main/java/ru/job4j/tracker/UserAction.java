package ru.job4j.tracker;

/**
 * Интерфейс описывает действия меню
 * @author Evgenii Maslakov
 * @version 1.0
 */
public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}
