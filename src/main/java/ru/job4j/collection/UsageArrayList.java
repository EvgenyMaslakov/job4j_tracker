package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList<>();
        test.add("Petr");
        test.add("Ivan");
        test.add("Stepan");
        for (Object i : test) {
            System.out.println(i);
        }
    }
}
