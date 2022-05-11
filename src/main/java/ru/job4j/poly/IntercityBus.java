package ru.job4j.poly;

public class IntercityBus implements Vehicle {
    private int maxPassengers;

    public IntercityBus(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " ездит по скоростному шоссе");
    }

    @Override
    public void passengers() {
        System.out.println(getClass().getSimpleName() + " вмещает: " + maxPassengers + " пассажиров");
    }
}
