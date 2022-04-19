package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int leng = left.length() <= right.length() ? left.length() : right.length();
        int rsl = 0;
        char li = '\u0000';
        char ri = '\u0000';
        for (int i = 0; i < leng - 1; i++) {
            li = left.charAt(i);
            ri = right.charAt(i);
            rsl = Character.compare(li, ri);
            if (rsl == 0) {
                i++;
            } else {
                break;
            }
        }
        if (rsl == 0 && left.length() != right.length()) {
            rsl = left.length() - right.length();
        }
        return rsl;
    }
}
