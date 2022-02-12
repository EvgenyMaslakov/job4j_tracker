package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активность: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[]args) {
        Error error = new Error();
        Error bug = new Error(true, 1, "Найден баг");
        Error typo = new Error(false, 0, "Опечатка не найдена");
        Error fail = new Error(true, 1, "Неудача");
        error.printInfo();
        bug.printInfo();
        typo.printInfo();
        fail.printInfo();
    }
}
