package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private String teeth;

    public Dentist(String name, String surname, String education, String birthday, String speciality, String teeth) {
        super(name, surname, education, birthday, speciality);
        this.teeth = teeth;
    }

    public DentalTreatment() {
    }
}
