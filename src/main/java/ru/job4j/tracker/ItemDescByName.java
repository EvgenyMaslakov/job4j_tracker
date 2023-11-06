package ru.job4j.tracker;

import java.util.Comparator;

/**
 *
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return second.getName().compareTo(first.getName());
    }
}
