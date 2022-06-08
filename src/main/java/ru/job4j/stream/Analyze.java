package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс получает статистику по аттестатам
 * @author Maslakov Evgeny
 * @version 1.0
 */
public class Analyze {

    /**
     * Вычисляет общий средний балл
     * @param stream список учеников
     * @return возвращает средний балл
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .mapToInt(s -> s.getScore())
                .average()
                .orElse(0);
    }

    /**
     * Вычисляет средний балл ученика по его предметам
     * @param stream список учеников
     * @return Возвращает список из объекта Tuple (имя ученика и средний балл)
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(p.getName(), p.getSubjects().stream()
                        .mapToInt(s -> s.getScore())
                        .average()
                        .orElse(0)))
                .collect(Collectors.toList());
    }

    /**
     * Вычисляет средний балл по всем предметам для каждого ученика
     * @param stream список учеников
     * @return Возвращает список из объекта Tuple (название предмета и средний балл)
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                        .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Определяет лучшего ученика. Лучшим считается ученик с наибольшим баллом по всем предметам
     * @param stream список учеников
     * @return Возвращает лучшего ученика
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(p.getName(), p.getSubjects().stream()
                        .mapToInt(s -> s.getScore())
                        .sum()))
                .max((left, right) -> Double.compare(left.getScore(), right.getScore()))
                .orElse(null);
    }

    /**
     * Определяет предмет с наибольшим баллом для всех студентов
     * @param stream список учеников
     * @return Возвращает объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .max((left, right) -> Double.compare(left.getScore(), right.getScore()))
                .orElse(null);
    }
}
