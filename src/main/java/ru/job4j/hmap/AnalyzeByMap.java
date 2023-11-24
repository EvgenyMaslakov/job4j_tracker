package ru.job4j.hmap;

import java.util.*;

/**
 * Класс AnalyzeByMap получает статистику по аттестатам
 */
public class AnalyzeByMap {
    /**
     * Метод averageScore() - вычисляет общий средний балл.
     * В этом методе необходимо найти сумму баллов по всем предметам у всех учеников,
     * при этом считая количество суммируемых элементов - после этих подсчетов мы
     * просто делим общий балл на количество суммируемых элементов.
     * @param pupils список учеников
     * @return возвращает общий средний балл
     */
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0;
        Map<String, Integer> subjectScore = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (subjectScore.containsKey(subject.name())) {
                    int score = subjectScore.get(subject.name());
                    subjectScore.put(subject.name(), score + subject.score());
                } else {
                    subjectScore.put(subject.name(), subject.score());
                }
            }
        }
        for (String subjectName: subjectScore.keySet()) {
            rsl += subjectScore.get(subjectName);
        }
        return rsl / subjectScore.size() / pupils.size();
    }

    /**
     * Метод averageScoreByPupil() - вычисляет средний балл по каждому ученику.
     * То есть берем одного ученика и считаем все его баллы за все предметы и делим на количество предметов.
     * Реализация этого метода будет отличаться от предыдущего тем, что мы считаем сумму баллов по всем предметам каждого ученика.
     * Получив сумму баллов, мы создаем объект типа Label с именем ученика, а в качестве второго параметра в конструктор передаем
     * сумму баллов по предметам, разделенную на количество предметов ученика.
     * Полученный объект добавляем в список, который и возвращаем в конце метода.
     * @param pupils список учеников
     * @return возвращает список из объектов Label (имя ученика и средний балл)
     */
    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            rsl.add(new Label(pupil.name(), score / pupil.subjects().size()));
        }
        return rsl;
    }

    /**
     * Метод averageScoreBySubject() - вычисляет средний балл по каждому предмету
     * Например, собираем все баллы учеников по предмету география и делим на количество учеников.
     * Чтобы реализовать данный метод, нам необходимо будет собрать временную Map<String, Integer>
     * (в качестве реализации используем LinkedHashMap) - в качестве ключа используем название предмета,
     * в качестве значения - сумма баллов по этому предмету, которую мы получим у каждого ученика.
     * Далее мы перебираем пары ключ-значение в цикле и на их основе создаем объекты типа Label - в
     * качестве первого параметра передаем ключ карты, в качестве второго - значение карты
     * разделенное на количество учеников. Созданный объект добавляем в результирующий список,
     * его мы и вернем в конце метода.
     * @param pupils список учеников
     * @return возвращает список из объектов Label (название предмета и средний балл)
     */
    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, Integer> scoreSubject = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (scoreSubject.containsKey(subject.name())) {
                    int score = scoreSubject.get(subject.name());
                    scoreSubject.put(subject.name(), score + subject.score());
                } else {
                    scoreSubject.put(subject.name(), subject.score());
                }
            }
        }
        for (String subjectName : scoreSubject.keySet()) {
            rsl.add(new Label(subjectName, scoreSubject.get(subjectName) / pupils.size()));
        }
        return rsl;
    }

    /**
     * Метод bestStudent() - возвращает лучшего ученика.
     * Лучшим считается ученик с наибольшим суммарным баллом по всем предметам.
     * В данном методе, как и в методе averageScoreByPupil(), мы собираем список объектов Label
     * за одним исключением - среднее значение баллов считать не нужно, мы оставляем подсчитанную сумму баллов как есть.
     * Далее мы сортируем список с помощью Comparator.naturalOrder() (именно для этой цели у Label реализован интерфейс Comparable).
     * Поскольку нам нужен в итоге лучший студент - то в качестве результата мы возвращаем последний элемент из списка.
     * @param pupils список учеников
     * @return возвращает объект Label (имя ученика и суммарный балл)
     */
    public static Label bestStudent(List<Pupil> pupils) {
        String bestStudentName = "";
        int bestScoreSum = 0;
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            if (sum > bestScoreSum) {
                bestScoreSum = sum;
                bestStudentName = pupil.name();
            }
        }
        return new Label(bestStudentName, bestScoreSum);
    }

    /**
     * Метод bestSubject() - возвращает предмет с наибольшим баллом для всех студентов.
     * В этом методе, как и в методе averageScoreBySubject(), нам необходимо собрать временную карту.
     * Далее эту карту перебираем в виде пар ключ-значение и создаем объекты типа Label - в качестве первого
     * параметра используем ключ, для второго - значение карты. После этого мы сортируем список с помощью
     * Comparator.naturalOrder() и в итоге возвращаем последний элемент из полученного списка.
     * @param pupils список учеников
     * @return возвращает объект Label (имя предмета, сумма баллов каждого ученика по этому предмету).
     */
    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new LinkedList<>();
        Map<String, Integer> scoreSubject = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (scoreSubject.containsKey(subject.name())) {
                    int score = scoreSubject.get(subject.name());
                    scoreSubject.put(subject.name(), score + subject.score());
                } else {
                    scoreSubject.put(subject.name(), subject.score());
                }
            }
        }
        for (String subjectName : scoreSubject.keySet()) {
            labels.add(new Label(subjectName, scoreSubject.get(subjectName)));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}