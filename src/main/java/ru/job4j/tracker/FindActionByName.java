package ru.job4j.tracker;

import java.util.List;

/**
 * Класс описывает пункт меню "Показать заявки по имени"
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class FindActionByName implements UserAction {
    /**
     * Объект отвечающий за вывод данных в консоль
     */
    private final Output out;

    /**
     * Конструктор принимает объект отвечающий за вывод данных в консоль
     * @param out вывод данных в консоль
     */
    public FindActionByName(Output out) {
        this.out = out;
    }

    /**
     * Выводит название пункта меню "Показать заявки по имени"
     * @return возвращает имя меню
     */
    @Override
    public String name() {
        return "Показать заявки по имени";
    }

    /**
     * Метод описывает пункт меню "Показать заявки по имени"
     * @param input получает данные от пользователя
     * @param tracker хранилище заявок
     * @return возвращает boolean переменную, чтобы создать действия выхода из программы.
     * Если действие вернуло false, то мы считаем, что пользователь вышел из системы.
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Показ заявок по имени ===");
        String name = input.askStr("Введите имя: ");
        List<Item> items = tracker.findByName(name);
        if (!items.isEmpty()) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
