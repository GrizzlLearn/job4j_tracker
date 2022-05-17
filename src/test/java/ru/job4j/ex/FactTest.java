package ru.job4j.ex;

import org.junit.Test;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenFactorialCalcMinus1ThenException() {
        new Fact().calc(-1);
    }
}
