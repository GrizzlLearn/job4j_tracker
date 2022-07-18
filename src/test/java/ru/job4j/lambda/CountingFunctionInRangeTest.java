package ru.job4j.lambda;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class CountingFunctionInRangeTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = CountingFunctionInRange.diapason(5, 8, x -> 2 * x);
        List<Double> expected = Arrays.asList(10D, 12D, 14D);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenLinearFunctionThenQuadraticResults() {
        List<Double> result = CountingFunctionInRange.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenLinearFunctionThenExponentialResults() {
        List<Double> result = CountingFunctionInRange.diapason(5, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(32D, 64D, 128D);
        assertThat(result).isEqualTo(expected);
    }
}
