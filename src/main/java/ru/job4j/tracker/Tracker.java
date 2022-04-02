package ru.job4j.tracker;

import java.security.Key;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Tracker {

    private final List<Item> items = new ArrayList<>(100);
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = items.indexOf(item);
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.remove(index);
            items.add(index, item);
        }
        return index != -1;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
        }
        return index != -1;
    }
}