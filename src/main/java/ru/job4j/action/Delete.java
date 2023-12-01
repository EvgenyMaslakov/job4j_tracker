package ru.job4j.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

/**
 * Класс описывает пункт меню "Удалить заявку"
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class Delete implements UserAction {
    /**
     * Объект отвечающий за вывод данных в консоль
     */
    private final Output out;

    /**
     * Конструктор принимает объект отвечающий за вывод данных в консоль
     * @param out вывод данных в консоль
     */
    public Delete(Output out) {
        this.out = out;
    }

    /**
     * Выводит название пункта меню "Удалить заявку"
     * @return возвращает имя меню
     */
    @Override
    public String name() {
        return "Удалить заявку";
    }

    /**
     * Метод описывает пункт меню "Удалить заявку"
     * @param input получает данные от пользователя
     * @param tracker хранилище заявок
     * @return возвращает boolean переменную, чтобы создать действия выхода из программы.
     * Если действие вернуло false, то мы считаем, что пользователь вышел из системы.
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Удаление заявки ===");
        int id = input.askInt("Введите id: ");
        if (tracker.delete(id)) {
            out.println("Заявка удалена успешно.");
        } else {
            out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
