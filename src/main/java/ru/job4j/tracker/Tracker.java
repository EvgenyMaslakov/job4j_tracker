package ru.job4j.tracker;

import java.security.Key;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null) {
                rsl[size] = items[index];
                size++;
            }
        }
        rsl = Arrays.copyOf(rsl, size);
        for (int index = 0; index < rsl.length; index++) {
            System.out.println(rsl[index]);
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int sizes = 0;
            for (int index = 0; index < size; index++) {
                Item item = items[index];
                if (item.getName().equals(key)) {
                    rsl[index] = items[index];
                    sizes++;
                }
            }
        return Arrays.copyOf(rsl, sizes);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
        }
        return index != -1;
    }

}