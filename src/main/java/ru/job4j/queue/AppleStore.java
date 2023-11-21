package ru.job4j.queue;

import java.util.Queue;

/**
 * 1.3. Collections. Lite.
 * 1.3.3. Queue, Deque
 * 1. Интерфейс Queue
 * Класс, описывающий магазин
 */
public class AppleStore {

    /**
     * Очередь клиентов, которые пришли в магазин
     */
    private final Queue<Customer> queue;

    /**
     * Количество доступного к покупке товара
     */
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    /**
     * Метод определяет последнего покупателя
     * @return возвращает имя последнего счастливого обладателя желаемого товара
     */
    public String getLastHappyCustomer() {
        String rsl = "";
        int buyers = queue.size() < count ? queue.size() : count;
        for (int i = 0; i < buyers; i++) {
            rsl = queue.poll().name();
        }
        return rsl;
    }

    /**
     * Метод определяет первого покупателя, который не смог купить товар
     * @return возвращает имя первого клиента, которому сегодня не повезло и ему не хватило товара
     */
    public String getFirstUpsetCustomer() {
        String rsl = "";
        int buyers = queue.size() < count ? queue.size() : count;
        for (int i = 0; i < buyers; i++) {
            queue.poll();
        }
        rsl = queue.peek().name();
        return rsl;
    }
}
