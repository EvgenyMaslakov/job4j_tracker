package ru.job4j.tracker;

/**
 * Класс описывает пункт меню "Завершить программу"
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class ExitAction implements UserAction {
    /**
     * Выводит название пункта меню "Завершить программу"
     * @return возвращает имя меню
     */
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
        System.out.println("=== Программа завершена ===");
        return false;
    }
}
