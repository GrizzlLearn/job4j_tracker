package ru.job4j.loop;

public class MultiplicationLoop {
    public static int mult(int a, int b) {
        int rls = 1;
        for (; a <= b; a++) {
            rls *= a;
        }
        return rls;
    }
}
