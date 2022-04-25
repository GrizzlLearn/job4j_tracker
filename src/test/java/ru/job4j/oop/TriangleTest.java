package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        Assert.assertThat(rsl, closeTo(8, 0.001));
    }

    @Test
    public void when00and40and60ThenMinus1() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(6, 0);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        int expected = -1;
        Assert.assertEquals(expected, rsl, 0.001);
    }

    @Test
    public void when00and00and40ThenMinus1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        Point c = new Point(4, 0);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        int expected = -1;
        Assert.assertEquals(expected, rsl, 0.001);
    }

    @Test
    public void when04and00and08ThenMinus1() {
        Point a = new Point(0, 4);
        Point b = new Point(0, 0);
        Point c = new Point(0, 8);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        int expected = -1;
        Assert.assertEquals(expected, rsl, 0.001);
    }
}
