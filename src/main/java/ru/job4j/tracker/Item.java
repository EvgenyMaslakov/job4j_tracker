package ru.job4j.tracker;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Класс описывает модель заявления
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class Item implements Comparable<Item> {
    /**
     * Уникальный номер заявления.
     */
    private int id;
    /**
     * Название заявления.
     */
    private String name;
    /**
     * Дата создания заявления.
     */
    private LocalDateTime created = LocalDateTime.now();
    /**
     * Приводит дату создания заявления к виду dd-MMMM-EEEE-yyyy HH:mm:ss
     */
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", created=" + created.format(FORMATTER)
                + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public int compareTo(Item another) {
        return CharSequence.compare(name, another.name);
    }
}