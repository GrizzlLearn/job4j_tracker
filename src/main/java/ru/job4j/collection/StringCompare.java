package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int num = Integer.compare(left.length(), right.length());
        int minStrLength = Math.min(left.length(), right.length());

        for (int i = 0; i < minStrLength; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                result += Character.compare(left.charAt(i), right.charAt(i));
                break;
            }
        }
        if (result == 0 && num < 0) {
            result = -1;
        }
        return result;
    }
}
