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
     * - flatMap() для преобразования в поток объектов Subject;
     * - mapToInt() для последующего преобразования в потом оценок по каждому предмету;
     * - average() для расчета среднего бала по предмету;
     * - orElse() для того чтобы вернуть значение по умолчанию.
     * @param stream список учеников
     * @return возвращает средний балл
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0);
    }

    /**
     * Вычисляет средний балл ученика по его предметам
     * Поскольку нам надо выполнить преобразование в поток объектов класса Tuple,
     * последовательность будет следующей:
     * - метод map() для преобразования в поток объектов класса Tuple, внутри метода мы
     * будем создавать эти объекты - там будет фигурировать строка new Tuple();
     * - при этом в конструктор первым параметром будет передаваться имя текущего
     * объекта Pupil - используем соответствующий геттер;
     * - вторым параметром рассчитанный средний балл - расчет можно произвести по
     * той же последовательности, что описана для метода averageScore;
     * - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
     * @param stream список учеников
     * @return Возвращает список из объекта Tuple (имя ученика и средний балл)
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(p.getName(), p.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0)))
                .collect(Collectors.toList());
    }

    /**
     * Вычисляет средний балл по всем предметам для каждого ученика.
     * Реализация этого метода несколько сложна, поскольку в данном
     * случае требуется выполнить промежуточный сбор данных в Map().
     * - flatMap() для преобразования в поток объектов Subject;
     * - метод collect() в который мы передаем метод groupingBy() (с тремя параметрами)
     * класса Collectors. При этом карта собирается следующим образом: ключ (первый параметр) -
     * это имя предмета, второй параметр - тип карты, который будем использовать
     * (в нашем случае нужен LinkedHashMap::new, который позволит хранить пары ключ-значение
     * в порядке поступления), значение карты (третий параметр) - средний балл по этому предмету
     * для каждого ученика. Для расчета среднего балла используйте метод averagingDouble() класса
     * Collectors;
     * - после этого собранную карту мы разбираем с помощью entrySet() и открываем
     * поток с помощью stream();
     * - полученный поток с помощью map() преобразуем в поток объектов класса Tuple,
     * внутри метода мы будем создавать эти объекты - там будет фигурировать строка new Tuple();
     * - в конструктор мы будем передавать параметры с помощью методов getKey() и
     * getValue() интерфейса Entry;
     * - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
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
     * Определяет лучшего ученика. Лучшим считается ученик с наибольшим баллом по всем предметам.
     * Для реализации данного метода можно использовать метод averageScoreBySubject за исключением
     * следующих особенностей:
     * - в данном методе мы рассчитываем суммарный балл, а не средний - поэтому вместо average()
     * нужно использовать метод sum();
     * - терминальной операцией будет не метод collect(), а использование метода max(), в который
     * будем передавать компаратор. При этом компаратор определит объект Tuple, у которого значение
     * Score будет максимальным;
     * - orElse() для того чтобы вернуть значение по умолчанию.
     * @param stream список учеников
     * @return Возвращает лучшего ученика
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(p.getName(), p.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                .max((left, right) -> Double.compare(left.getScore(), right.getScore()))
                .orElse(null);
    }

    /**
     * Определяет предмет с наибольшим баллом для всех студентов.
     * Для реализации данного метода можно использовать метод averageScoreByPupil за
     * исключением следующих особенностей:
     * - в данном методе мы рассчитываем суммарный балл, а не средний - поэтому вместо
     * averagingDouble() нужно использовать метод summingDouble();
     * - терминальной операцией будет не метод collect(), а использование метода max(),
     * в который будем передавать компаратор. При этом компаратор определит объект Tuple,
     * у которого значение Score будет максимальным;
     * - orElse() для того чтобы вернуть значение по умолчанию.
     * @param stream список учеников
     * @return Возвращает объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .max((left, right) -> Double.compare(left.getScore(), right.getScore()))
                .orElse(null);
    }
}
