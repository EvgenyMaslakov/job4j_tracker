package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ItemTest {
    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Ложка", 1),
                new Item("Вилка", 2),
                new Item("Нож", 3)
        );
        Collections.sort(items);
        List<Item> expected = Arrays.asList(
                new Item("Вилка", 2),
                new Item("Ложка", 1),
                new Item("Нож", 3)
        );
        assertThat(items, is(expected));
    }

    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Ложка", 1),
                new Item("Вилка", 2),
                new Item("Нож", 3)
        );
        Collections.sort(items, Collections.reverseOrder());
        List<Item> expected = Arrays.asList(
                new Item("Нож", 3),
                new Item("Ложка", 1),
                new Item("Вилка", 2)
        );
        assertThat(items, is(expected));
    }
}