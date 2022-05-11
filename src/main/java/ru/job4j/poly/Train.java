package ru.job4j.poly;

public class Train implements Vehicle {
    private int maxPassengers;

    public Train(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " ездит по рельсам");
    }

    @Override
    public void passengers() {
        System.out.println(getClass().getSimpleName() + " вмещает: " + maxPassengers + " пассажиров");
    }
}
