package ru.job4j.hashmap;

/**
 * Класс Subject описывает школьный предмет и аттестационный балл ученика.
 * @param name название школьного предмета
 * @param score балл ученика
 */
public record Subject(String name, int score) {
}
