package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        String ln = System.lineSeparator();
        Student student = new Student();
        student.setName("Dmitry Lebedev");
        student.setGroup("Стажер");
        student.setReceiptDate("28.03.2022 20:51");

        System.out.println("Student name: " + student.getName() + ln
                        + "Student Group: " + student.getGroup() + ln
                        + "Student Receipt Date: " + student.getReceiptDate());
    }
}
