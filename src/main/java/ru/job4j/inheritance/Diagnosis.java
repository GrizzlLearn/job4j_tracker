package ru.job4j.inheritance;

public class Diagnosis {
    private String disease;

    public Diagnosis() {
        this.disease = "fake";
    }

    public String heal(Patient patient) {
        return this.disease;
    }
}
