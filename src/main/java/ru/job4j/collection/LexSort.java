package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] sLeft = left.split("\\. ");
        String[] sRight = right.split("\\. ");
        int nLeft = Integer.parseInt(sLeft[0]);
        int nRight = Integer.parseInt(sRight[0]);

        return Integer.compare(nLeft, nRight);
    }
}
