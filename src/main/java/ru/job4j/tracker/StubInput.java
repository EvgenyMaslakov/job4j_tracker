package ru.job4j.tracker;

import java.util.List;

/**
 * Определять работу класса по получению данных из памяти.
 * Один для консоли, другой для тестов.
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class StubInput implements Input {
    /**
     * варианты ответов пользователя
     */
    private List<String> answers;

    /**
     * счетчик, чтобы при повторном вызове метода askStr мы получали следующую ячейку из
     * массива ответов пользователя
     */
    private int position = 0;

    /**
     * Принимает варианты ответов пользователя
     * @param answers варианты ответов пользователя
     */
    public StubInput(List<String> answers) {
        this.answers = answers;
    }

    /**
     * возвращает параметры, из заранее подготовленного списка ответов пользователя
     * @param question сообщение, которое выводится пользователю перед его вводом
     * @return возвращает параметры, из заранее подготовленного списка ответов пользователя
     */
    @Override
    public String askStr(String question) {
        return answers.get(position++);
    }

    /**
     * Возвращать от пользователя число из заранее подготовленного списка
     * @param question сообщение, которое выводится пользователю перед его вводом
     * @return Возвращать от пользователя число из заранее подготовленного списка
     */
    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
