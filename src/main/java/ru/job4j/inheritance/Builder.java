package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String buildType;

    public Builder(String name, String surname, String education, String birthday, Integer experienceInYear, String buildType) {
        super(name, surname, education, birthday, experienceInYear);
        this.buildType = buildType;
    }

    public String getBuildType() {
        return this.buildType;
    }
}
