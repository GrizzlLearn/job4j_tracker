package ru.job4j.oop;

import static java.lang.Math.sqrt;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point a, Point b, Point c) {
        this.first = a;
        this.second = b;
        this.third = c;
    }

    public boolean exist(double a, double b, double c) {
        return a + b > c && b + c > a && a + c > b;
    }

    public double area() {
        double a = first.distance(second);
        double b = second.distance(third);
        double c = third.distance(first);
        if (exist(a, b, c)) {
            double p = semiPerimeter(a, b, c);
            return sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return -1;
    }

    public double semiPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

}
