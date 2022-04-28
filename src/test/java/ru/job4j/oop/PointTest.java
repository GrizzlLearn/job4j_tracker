package ru.job4j.oop;

import org.junit.Test;
import org.junit.Assert;

public class PointTest {

    @Test
    public void when02to00then2() {
        double expected = 2;
        Point point1 = new Point(0, 0);
        Point point2 = new Point(2, 0);
        double out = point1.distance(point2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when42to08then8dot24() {
        double expected = 8.24;
        Point point1 = new Point(4, 0);
        Point point2 = new Point(2, 8);
        double out = point1.distance(point2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when64to00then2() {
        double expected = 2;
        Point point1 = new Point(6, 0);
        Point point2 = new Point(4, 0);
        double out = point1.distance(point2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when81to61then8dot6() {
        double expected = 8.6;
        Point point1 = new Point(8, 6);
        Point point2 = new Point(1, 1);
        double out = point1.distance(point2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when861To111Then8dot6() {
        double expected = 8.6;
        Point point1 = new Point(8, 6, 1);
        Point point2 = new Point(1, 1, 1);
        double out = point1.distance3d(point2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when847To125Then7dot54() {
        double expected = 7.54;
        Point point1 = new Point(8, 4, 7);
        Point point2 = new Point(1, 2, 5);
        double out = point1.distance3d(point2);
        Assert.assertEquals(expected, out, 0.01);
    }
}
