package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String program;

    public Programmer(String name, String surname, String education, String birthday, String category, String program) {
        super(name, surname, education, birthday, category);
        this.program = program;
    }

    public ProgramDevelopment() {
    }
}
