package ru.job4j.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

/**
 * Интерфейс описывает пункты меню в нашем приложении
 * @author Evgenii Maslakov
 * @version 1.0
 */
public interface UserAction {
    /**
     * Выводит название пункта меню в нашем приложении
     * @return возвращает имя меню
     */
    String name();

    /**
     * Метод описывает один из пунктов меню в нашем приложении
     * @param input получает данные от пользователя
     * @param tracker хранилище заявок
     * @return возвращает boolean переменную, чтобы создать действия выхода из программы.
     * Если действие вернуло false, то мы считаем, что пользователь вышел из системы.
     */
    boolean execute(Input input, Tracker tracker);
}
