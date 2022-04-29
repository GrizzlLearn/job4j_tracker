package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name, String surname, String education, String birthday, Integer experienceInYear, String language) {
        super(name, surname, education, birthday, experienceInYear);
        this.language = language;
    }

    public String getLanguage() {
        return this.language;
    }

}
