package ru.job4j.tracker;

/**
 * Определять работу класса по получению заранее подготовленных данных для тестов.
 * Один для консоли, другой для тестов.
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class MockInput implements Input {
    /**
     * варианты ответов пользователя
     */
    private String[] answers;
    /**
     * счетчик, чтобы при повторном вызове метода askStr мы получали следующую ячейку из
     * массива ответов пользователя
     */
    private int position = 0;

    /**
     *
     * @param answers
     */
    public MockInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * возвращает параметры, из заранее подготовленного массива ответов пользователя
     * @param question сообщение, которое выводится пользователю перед его вводом
     * @return возвращает параметры, из заранее подготовленного массива ответов пользователя
     */
    @Override
    public String askStr(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
