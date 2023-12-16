package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class PeekExample {
    public static void main(String[] args) {
        List<StringBuilder> names = Arrays.asList(
                new StringBuilder("Михаил"), new StringBuilder("Иван"), new StringBuilder("Елена"));
        List<StringBuilder> editedNames = names
                .stream()
                .peek(System.out::println)
                .peek((element) -> element.append(" (Ученик Job4j)"))
                .peek(System.out::println)
                .sorted()
                .toList();
        System.out.println(editedNames);
    }
}
