package ru.job4j.map;

import ru.job4j.collection.Job;

import java.util.Comparator;

public class PupilDescByScore implements Comparator<Label> {
    @Override
    public int compare(Label o1, Label o2) {
        return Double.compare(o2.score(), o1.score());
    }
}
