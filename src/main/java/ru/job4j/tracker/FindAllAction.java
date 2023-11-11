package ru.job4j.tracker;

import java.util.List;

/**
 * Класс описывает пункт меню "Показать все заявки"
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class FindAllAction implements UserAction {
    /**
     * Объект отвечающий за вывод данных в консоль
     */
    private final Output out;

    /**
     * Конструктор принимает объект отвечающий за вывод данных в консоль
     * @param out вывод данных в консоль
     */
    public FindAllAction(Output out) {
        this.out = out;
    }

    /**
     * Выводит название пункта меню "Показать все заявки"
     * @return возвращает имя меню
     */
    @Override
    public String name() {
        return "Показать все заявки";
    }

    /**
     * Метод описывает пункт меню "Показать все заявки"
     * @param input получает данные от пользователя
     * @param tracker хранилище заявок
     * @return возвращает boolean переменную, чтобы создать действия выхода из программы.
     * Если действие вернуло false, то мы считаем, что пользователь вышел из системы.
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Показ всех заявок ===");
        List<Item> items = tracker.findAll();
        if (!items.isEmpty()) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
