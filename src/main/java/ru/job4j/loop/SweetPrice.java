package ru.job4j.loop;

public class SweetPrice {
    public static void out(int price) {
        for (int i = 1; i < 6; i++) {
            System.out.println(price * i);
        }
    }
}
