package ru.job4j.map;

import java.util.Comparator;

public class LabelAscByScore implements Comparator<Label> {
    @Override
    public int compare(Label o1, Label o2) {
        return Double.compare(o1.score(), o2.score());
    }
}
