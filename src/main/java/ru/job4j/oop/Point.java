package ru.job4j.oop;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Point {

    private int x;
    private int y;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }

    public static void main(String[] args) {
        Point point1 = new Point(0, 2);
        Point point2 = new Point(0, 0);
        double result = point1.distance(point2);
        System.out.println("result (0, 2) to (0, 0) " + result);
    }
}
