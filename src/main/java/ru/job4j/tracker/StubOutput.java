package ru.job4j.tracker;

/**
 * Класс заглушка вывода данных в консоль
 * Используется для тестов
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class StubOutput implements Output {
    /**
     * Складывает строки
     */
    private final StringBuilder buffer = new StringBuilder();

    /**
     * Добавляет строки в buffer
     * @param obj данные, которые выводятся на консоль
     */
    @Override
    public void println(Object obj) {
        if (obj != null) {
            buffer.append(obj);
        } else {
            buffer.append("null");
        }
        buffer.append(System.lineSeparator());
    }

    /**
     * Извлекает всю строку из buffer
     * @return возвращает строку из buffer
     */
    @Override
    public String toString() {
        return buffer.toString();
    }
}
