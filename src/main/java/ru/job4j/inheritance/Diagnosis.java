package ru.job4j.inheritance;

public class Diagnosis {
    private String disease;

    public Diagnosis(String disease) {
        this.disease = disease;
    }

    public String heal(Patient patient) {
        return this.disease;
    }
}
