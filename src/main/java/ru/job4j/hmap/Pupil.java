package ru.job4j.hmap;

import java.util.List;

/**
 * Класс Pupil описывает ученика
 * @param name имя ученика
 * @param subjects школьные предметы
 */
public record Pupil(String name, List<Subject> subjects) {
}
