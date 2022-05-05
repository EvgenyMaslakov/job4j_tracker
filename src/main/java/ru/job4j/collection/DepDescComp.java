package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        List<String> rslO1 = new ArrayList<>();
        for (String el : o1.split("/")) {
            rslO1.add(el);
        }
        List<String> rslO2 = new ArrayList<>();
        for (String el : o2.split("/")) {
            rslO2.add(el);
        }
        rsl = rslO2.get(0).compareTo(rslO1.get(0));
        if (rsl == 0) {
            return o1.compareTo(o2);
        }
        return rsl;
    }
}
