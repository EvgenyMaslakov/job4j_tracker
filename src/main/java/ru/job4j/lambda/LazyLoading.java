package ru.job4j.lambda;

import java.util.Comparator;
import java.util.Arrays;

public class LazyLoading {
    public static void main(String[] args) {
        String[] names = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(names, lengthCmp);
    }
}
