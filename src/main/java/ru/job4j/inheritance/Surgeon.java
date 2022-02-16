package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String operation;

    public Surgeon(String name, String surname, String education, String birthday, String speciality, String operation) {
        super(name, surname, education, birthday, speciality);
        this.operation = operation;
    }

    public surgery() {
    }
}
