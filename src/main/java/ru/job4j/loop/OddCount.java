package ru.job4j.loop;

public class OddCount {
    public static int count(int a, int b) {
        int rsl = 0;
        for (; a <= b; a++) {
            if (a % 2 != 0) {
                rsl++;
            }
        }
        return rsl;
    }
}
