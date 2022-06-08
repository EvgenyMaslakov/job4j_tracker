package ru.job4j.stream;

import java.util.List;

/**
 * Класс описывает ученика
 * @author Maslakov Evgeny
 * @version 1.0
 */
public class Pupil {
    /**
     * Имя ученика
     */
    private String name;
    /**
     * Список предметов с аттестационными баллами ученика
     */
    private List<Subject> subjects;

    public Pupil(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
