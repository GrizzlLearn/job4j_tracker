package ru.job4j.inheritance;

public class Engineer extends Profession {

    private Integer experienceInYear;

    public Engineer(String name, String surname, String education, String birthday, Integer experienceInYear) {
        super(name, surname, education, birthday);
        this.experienceInYear = experienceInYear;
    }

    public Integer getExperienceInYear() {
        return this.experienceInYear;
    }
}
