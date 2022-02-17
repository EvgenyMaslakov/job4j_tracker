package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Maslakov Evgeny Vladimirovich");
        student.setGroup("2949");
        student.setReceiptData(new Date());

        System.out.println("ФИО: " + student.getFullName()
                + " Группа: " + student.getGroup()
                + " Дата поступления: " + student.getReceiptData());
    }
}
