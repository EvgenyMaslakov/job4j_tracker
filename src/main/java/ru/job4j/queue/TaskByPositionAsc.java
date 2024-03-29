package ru.job4j.queue;

import java.util.Comparator;

/**
 * Компаратор сортирует по полю position по возрастанию
 * У Enum уже реализован метод compareTo()
 */
public class TaskByPositionAsc implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        return o1.position().compareTo(o2.position());
    }
}