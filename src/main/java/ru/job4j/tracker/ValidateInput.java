package ru.job4j.tracker;

/**
 * Определять работу класса по получению данных от пользователя в консоли включая валидацию.
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class ValidateInput implements Input {
    private final Output out;
    private final Input in;

    public ValidateInput(Output out, Input input) {
        this.out = out;
        this.in = input;
    }

    /**
     * Возвращает введенную строку от пользователя, включая валидацию
     * @param question сообщение, которое выводится пользователю перед его вводом
     * @return Возвращает введенную строку от пользователя.
     */
    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    /**
     * Возвращать от пользователя число, а не строку, включая валидацию
     * @param question сообщение, которое выводится пользователю перед его вводом
     * @return Возвращать от пользователя число, а не строку
     */
    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.println("Пожалуйста, введите данные для подтверждения еще раз.");
            }
        } while (invalid);
        return value;

    }
}
