package ru.job4j.inheritance;

public class Doctor extends Profession {
    private Integer experienceInYear;

    public Doctor(String name, String surname, String education, String birthday, Integer experienceInYear) {
        super(name, surname, education, birthday);
        this.experienceInYear = experienceInYear;
    }

    public Integer getExperienceInYear() {
        return this.experienceInYear;
    }

    
}
