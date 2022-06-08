package ru.job4j.stream;

/**
 * Класс описывает школьный предмет и аттестационный балл ученика
 * @author Maslakov Evgeny
 * @version 1.0
 */
public class Subject {
    /**
     * Название предмета
     */
    private String name;
    /**
     * Аттестационный балл ученика
     */
    private int score;

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
