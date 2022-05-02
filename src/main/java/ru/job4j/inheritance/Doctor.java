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

    public static void main(String[] args) {
        Patient patient = new Patient("Oleg", "male", "pain");
        Diagnosis diagnosis = new Diagnosis(patient.getDiagnosis());
        System.out.println(diagnosis.heal(patient));
    }
}
