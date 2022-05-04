package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int leng = o1.length() <= o2.length() ? o1.length() : o2.length();
        int rsl = 0;
        for (int i = 0; i < leng; i++) {
            if (i <= 1) {
                rsl = Character.compare(o2.charAt(i), o1.charAt(i));
            } else {
                rsl = Character.compare(o1.charAt(i), o2.charAt(i));
            }
            if (rsl != 0) {
                return rsl;
            }
        }
        if (o1.length() != o2.length() && o2.length() == 2) {
            return Integer.compare(o1.length(), o2.length());
        }
        return Integer.compare(o1.length(), o2.length());
    }
}
