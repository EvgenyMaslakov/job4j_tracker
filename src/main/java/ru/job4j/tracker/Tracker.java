package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, описывающий хранилище.
 * Объект этого класса умеет: добавлять, заменять, искать по имени,
 * читать все сохраненные данные.
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class Tracker {
    /**
     * Список заявок.
     */
    private final List<Item> items = new ArrayList<>();
    /**
     * Поле используется для генерации нового ключа.
     * Каждый вызов метод add будет добавлять в поле ids единицу.
     * Так обеспечивается уникальность поля id в Item.
     */
    private int ids = 1;

    /**
     * Метод добавляет заявку, переданную в аргументах в список заявок items.
     * Метод setId проставляет уникальный ключ в объект Item item.
     * @param item заявка для добавления
     * @return возвращает добавленную заявку
     */
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    /**
     * Метод получения списка всех заявок.
     * @return возвращает копию списка items
     */
    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    /**
     * Метод получения списка заявок по имени.
     * Проверяет в цикле все элементы массива items, сравнивая name
     * (используя метод getName класса Item) с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий массив и
     * возвращает его.
     * @param key имя заявки
     * @return возвращает список заявок по имени key
     */
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl;
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
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /**
     * Метод поиска ячейки с id приходящем в параметре.
     * @param id искомый id
     * @return взвращает id если он найден и -1 если не найден
     */
    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
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
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
        }
        return index != -1;
    }

    /**
     * Метод удаления заявки.
     * Находим ячейку с id с помощью метода indexOf(id).
     * Если нашли ячейку, удаляем заявку.
     * @param id - id заявки, которую хотим удалить
     * @return возвращает true, если заявка удалена или false, если index по id не найден.
     */
    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
        }
        return index != -1;
    }
}