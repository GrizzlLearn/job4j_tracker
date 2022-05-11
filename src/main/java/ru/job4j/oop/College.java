package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student fm = freshman;
        Object ofm = fm;

        System.out.println(freshman);
        System.out.println(fm);
        System.out.println(ofm);
    }
}
