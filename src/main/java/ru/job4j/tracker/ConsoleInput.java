package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Определяет работу класса по получению данных от пользователя в консоли.
 * @author Evgenii Maslakov
 * @version 1.0
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Возвращает введенную строку от пользователя.
     * @param question сообщение, которое выводится пользователю перед его вводом
     * @return Возвращает введенную строку от пользователя.
     */
    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Возвращать от пользователя число, а не строку
     * @param question сообщение, которое выводится пользователю перед его вводом
     * @return Возвращать от пользователя число, а не строку
     */
    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
