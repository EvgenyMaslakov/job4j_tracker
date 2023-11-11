package ru.job4j.tracker;

/**
 * Класс описывает пункт меню "Добавить новую заявку"
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class CreateAction implements UserAction {
    /**
     * Объект отвечающий за вывод данных в консоль
     */
    private final Output out;

    /**
     * Конструктор принимает объект отвечающий за вывод данных в консоль
     * @param out вывод данных в консоль
     */
    public CreateAction(Output out) {
        this.out = out;
    }

    /**
     * Выводит название пункта меню "Добавить новую заявку"
     * @return возвращает имя меню
     */
    @Override
    public String name() {
        return "Добавить новую заявку";
    }

    /**
     * Метод описывает пункт меню "Добавить новую заявку"
     * @param input получает данные от пользователя
     * @param tracker хранилище заявок
     * @return возвращает boolean переменную, чтобы создать действия выхода из программы.
     * Если действие вернуло false, то мы считаем, что пользователь вышел из системы.
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Создание новой заявки ===");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
        return true;
    }
}
