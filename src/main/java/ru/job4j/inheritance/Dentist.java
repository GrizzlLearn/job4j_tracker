package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private boolean hasDoctorate;

    public Dentist(String name, String surname, String education, String birthday, Integer experienceInYear, boolean hasDoctorate) {
        super(name, surname, education, birthday, experienceInYear);
        this.hasDoctorate = hasDoctorate;
    }

    public boolean isHasDoctorate() {
        return this.hasDoctorate;
    }
}
