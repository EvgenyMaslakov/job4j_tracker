package ru.job4j.tracker;

/**
 * Класс добавляет поведение валидации к вводу данных с клавиатуры или из заготовленного списка
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class ValidateInput implements Input {
    /**
     * Объект отвечающий за вывод данных в консоль
     */
    private final Output out;

    /**
     * Объект определяет источник данных
     * С клавиатуры или из заготовленного списка
     */
    private final Input input;

    /**
     * Конструктор определяет каким образом будут вводиться данные.
     * С клавиатуры или из заготовленного списка
     * @param out вывод данных в консоль
     * @param input реализация ввода данных с клавиатуры или из заготовленного списка
     */
    public ValidateInput(Output out, Input input) {
        this.out = out;
        this.input = input;
    }

    /**
     * Возвращает введенную строку
     * @param question сообщение, которое выводится пользователю перед его вводом
     * @return Возвращает введенную строку от пользователя.
     */
    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    /**
     * Возвращать число, а не строку, включая валидацию
     * @param question сообщение, которое выводится пользователю перед его вводом
     * @return Возвращать от пользователя число, а не строку
     */
    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.println("Пожалуйста, введите данные для подтверждения еще раз.");
            }
        } while (invalid);
        return value;

    }
}
