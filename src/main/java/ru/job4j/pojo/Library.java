package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 10);
        Book harryPotter = new Book("Harry Potter", 300);
        Book warAndPeace = new Book("War and Peace", 500);
        Book bun = new Book("Bun", 15);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = harryPotter;
        books[2] = warAndPeace;
        books[3] = bun;
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            System.out.println("Имя: " + pr.getName() + " - Количество страниц: " + pr.getNumberOfPages());
        }
        Book vr = books[0];
        books[0] = books[3];
        books[3] = vr;
        System.out.println("Переставлены местами книги с индексом 0 и 3");
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            System.out.println("Имя: " + pr.getName() + " - Количество страниц: " + pr.getNumberOfPages());
        }
        System.out.println("Вывод книг с именем \"Clean code\"");
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            if ("Clean code".equals(pr.getName())) {
                System.out.println("Имя: " + pr.getName() + " - Количество страниц: " + pr.getNumberOfPages());
            }
        }
    }
}
