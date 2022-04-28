package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void whenMax1To2Then2() {
        int left = 1;
        int right = 2;
        int result = Max.max(left, right);
        int expected = 2;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax6To3Then6() {
        int left = 6;
        int right = 3;
        int result = Max.max(left, right);
        int expected = 6;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax3To9Then9() {
        int left = 3;
        int right = 9;
        int result = Max.max(left, right);
        int expected = 9;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax9To9Then9() {
        int left = 9;
        int right = 9;
        int result = Max.max(left, right);
        int expected = 9;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenA8B2C5Max8() {
        int a = 8;
        int b = 2;
        int c = 5;
        int result = Max.max(a, b, c);
        int expected = 8;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenA8B8C8Max8() {
        int a = 8;
        int b = 8;
        int c = 8;
        int result = Max.max(a, b, c);
        int expected = 8;
        Assert.assertEquals(result, expected);
    }
}
