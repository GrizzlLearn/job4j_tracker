package ru.job4j.inheritance;

public class Patient {
    private String name;
    private String sex;
    private String diagnosis;

    public Patient() {

    }

    public Patient(String name, String sex, String diagnosis) {
        this.name = name;
        this.sex = sex;
        this.diagnosis = diagnosis;
    }

    public String getName() {
        return this.name;
    }

    public String getSex() {
        return this.sex;
    }

    public String getDiagnosis() {
        return this.diagnosis;
    }

}
