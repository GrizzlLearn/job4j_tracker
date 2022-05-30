package ru.job4j.condition;

public class AttackRook {
    public static boolean check(String left, String right) {
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) == right.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
