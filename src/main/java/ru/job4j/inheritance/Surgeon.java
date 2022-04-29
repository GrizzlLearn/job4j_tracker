package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String surgeonType;

    public Surgeon(String name, String surname, String education, String birthday, Integer experienceInYear, String surgeonType) {
        super(name, surname, education, birthday, experienceInYear);
        this.surgeonType = surgeonType;
    }

    public String getSurgeonType() {
        return this.surgeonType;
    }
}
