package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        ArrayList<Integer> list = new ArrayList<Integer>() {
            @Override
            public boolean add(Integer o) {
                System.out.println("Add a new element to list: " + o);
                return super.add(o);
            }
        };
        list.add(100500);
        Comparator<Attachment> comparator2 = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                int leng = left.getName().length() <= right.getName().length()
                        ? left.getName().length() : right.getName().length();
                int rsl = 0;
                for (int i = 0; i < leng; i++) {
                    rsl = Character.compare(left.getName().charAt(i),
                            right.getName().charAt(i));
                    if (rsl != 0) {
                        return rsl;
                    }
                }
                return Integer.compare(left.getName().length(),
                        right.getName().length());
            }
        };
        attachments.sort(comparator2);
        System.out.println(attachments);
    }
}
