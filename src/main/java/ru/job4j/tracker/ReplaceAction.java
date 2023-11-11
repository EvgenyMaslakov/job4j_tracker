package ru.job4j.tracker;

/**
 * Класс описывает пункт меню "Изменить заявку"
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class ReplaceAction implements UserAction {
    /**
     * Объект отвечающий за вывод данных в консоль
     */
    private final Output out;

    /**
     * Конструктор принимает объект отвечающий за вывод данных в консоль
     * @param out вывод данных в консоль
     */
    public ReplaceAction(Output out) {
        this.out = out;
    }

    /**
     * Выводит название пункта меню "Изменить заявку"
     * @return возвращает имя меню
     */
    @Override
    public String name() {
        return "Изменить заявку";
    }

    /**
     * Метод описывает пункт меню "Изменить заявку"
     * @param input получает данные от пользователя
     * @param tracker хранилище заявок
     * @return возвращает boolean переменную, чтобы создать действия выхода из программы.
     * Если действие вернуло false, то мы считаем, что пользователь вышел из системы.
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Изменение заявки ===");
        int id = input.askInt("Введите id: ");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Заявка изменена успешно.");
        } else {
            out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
