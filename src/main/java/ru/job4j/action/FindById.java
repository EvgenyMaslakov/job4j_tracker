package ru.job4j.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

/**
 * Класс описывает пункт меню "Показать заявку по id"
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class FindById implements UserAction {
    /**
     * Объект отвечающий за вывод данных в консоль
     */
    private final Output out;

    /**
     * Конструктор принимает объект отвечающий за вывод данных в консоль
     * @param out вывод данных в консоль
     */
    public FindById(Output out) {
        this.out = out;
    }

    /**
     * Выводит название пункта меню "Показать заявку по id"
     * @return возвращает имя меню
     */
    @Override
    public String name() {
        return "Показать заявку по id";
    }

    /**
     * Метод описывает пункт меню "Показать заявку по id"
     * @param input получает данные от пользователя
     * @param tracker хранилище заявок
     * @return возвращает boolean переменную, чтобы создать действия выхода из программы.
     * Если действие вернуло false, то мы считаем, что пользователь вышел из системы.
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Показ заявки по id ===");
        int id = input.askInt("Введите id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
