package ru.job4j.oop;

public class Max {
    public static int max(int left, int right) {
        return left >= right ? left : right;
    }

    public static int max(int a, int b, int c) {
        return max(max(a, b), c);
    }
}
