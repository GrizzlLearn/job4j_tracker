package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CountingFunctionInRange {
    public static List<Double> diapason(Integer start, Integer fin, Function<Double, Double> calc) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i < fin; i++) {
            result.add(calc.apply((double) i));
        }
        return result;
    }
}
