package ru.job4j.poly;

public class Airplane implements Vehicle {
    private int maxPassengers;

    public Airplane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху");
    }

    @Override
    public void passengers() {
        System.out.println(getClass().getSimpleName() + " вмещает: " + maxPassengers + " пассажиров");
    }
}
