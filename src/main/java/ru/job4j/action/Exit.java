package ru.job4j.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

/**
 * Класс описывает пункт меню "Завершить программу"
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class Exit implements UserAction {
    /**
     * Объект отвечающий за вывод данных в консоль
     */
    private final Output out;

    /**
     * Выводит название пункта меню "Завершить программу"
     * @return возвращает имя меню
     */

    /**
     * Конструктор принимает объект отвечающий за вывод данных в консоль
     * @param out вывод данных в консоль
     */
    public Exit(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Завершить программу";
    }

    /**
     * Метод описывает пункт меню "Завершить программу"
     * @param input получает данные от пользователя
     * @param tracker хранилище заявок
     * @return возвращает boolean переменную, чтобы создать действия выхода из программы.
     * Если действие вернуло false, то мы считаем, что пользователь вышел из системы.
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
       out.println("=== Программа завершена ===");
        return false;
    }
}
