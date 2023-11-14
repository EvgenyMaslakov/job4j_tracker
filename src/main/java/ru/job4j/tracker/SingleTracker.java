package ru.job4j.tracker;

import java.util.List;

/**
 * Класс реализует шаблон singleton, который гарантирует,
 * что в приложении может быть только один экземпляр класса Tracker
 * Запрещено наследование данного класса
 * @author Evgenii Maslakov
 * @version 1.0
 */
public final class SingleTracker {
    /**
     * Объект класса Tracker
     */
    private Tracker tracker = new Tracker();

    /**
     * Ссылка на единственный объект класса SingleTracker
     */
    private static SingleTracker instance = null;

    /**
     * Закрытый конструктор, чтобы нельзя было создать новый объект
     */
    private SingleTracker() {
    }

    /**
     * Метод, чтобы другие классы могли получить ссылку на объект
     * класса SingleTracker
     * @return возвращает объект класса SingleTracker
     */
    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    /**
     * Метод добавляет заявку, переданную в аргументах в список заявок items.
     * @param item заявка для добавления
     * @return возвращает добавленную заявку
     */
    public Item add(Item item) {
        return tracker.add(item);
    }

    /**
     * Метод получения списка всех заявок.
     * @return возвращает копию списка всех заявок
     */
    public List<Item> findAll() {
        return tracker.findAll();
    }

    /**
     * Метод получения списка заявок по имени.
     * Проверяет в цикле все элементы массива items, сравнивая name
     * (используя метод getName класса Item) с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий список и
     * возвращает его.
     * @param key имя заявки
     * @return возвращает список заявок по имени key
     */
    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    /**
     * Метод получения заявки по id.
     * Проверяет в цикле все элементы списка items, сравнивая id с аргументом
     * int id, с помощью метода indexOf(id)
     * Если id найден, возвращает Item по id.
     * Если Item не найден - возвращает null.
     * @param id - id заявки
     * @return возвращает найденный Item. Если Item не найден - возвращает null.
     */
    public Item findById(int id) {
        return tracker.findById(id);
    }

    /**
     * Метод замены заявки.
     * Удаляем заявку, которая уже есть в системе и добавляет в эту ячейку новую.
     * Находим ячейку с id с помощью метода indexOf(id).
     * Проставляем id с item. При замене сохраняем старый id.
     * Записываем в ячейку с найденным индексом объект item. Это входящий параметр.
     * @param id - id заявки, которую будем заменять
     * @param item новая заявка
     * @return возвращает true, если замена произведена или false, если index по id не найден.
     */
    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    /**
     * Метод удаления заявки.
     * Находим ячейку с id с помощью метода indexOf(id).
     * Если нашли ячейку, удаляем заявку.
     * @param id - id заявки, которую хотим удалить
     * @return возвращает true, если заявка удалена или false, если index по id не найден.
     */
    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
