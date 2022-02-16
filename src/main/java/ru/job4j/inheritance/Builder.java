package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String drawing;

    public Builder(String name, String surname, String education, String birthday, String category, String drawing) {
        super(name, surname, education, birthday, category);
        this.drawing = drawing;
    }

    public String drawingDevelopment() {
        return "";
    }
}
