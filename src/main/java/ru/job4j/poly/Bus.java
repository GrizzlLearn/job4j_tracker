package ru.job4j.poly;

public class Bus implements Transport {
    private int passengersCount = 0;
    private int maxPassengers;
    private int fuelCount = 0;
    private int maxFuel;
    private boolean ride = false;

    public Bus(int maxPassengers, int maxFuel) {
        this.maxPassengers = maxPassengers;
        this.maxFuel = maxFuel;
    }

    @Override
    public void drive() {

        ride = passengersCount <= maxPassengers;

        System.out.println("Автобус едет: " + ride);
    }

    @Override
    public void passengers(int passengers) {
        if (passengers + passengersCount <= maxPassengers) {
            passengersCount += passengers;
            System.out.println("Актуальное число пассажиров: " + passengersCount);
        } else {
            System.out.println("Превышено максимальное число пассажиров!");
        }
    }

    @Override
    public int refuel(int fuel) {
        if (fuel + fuelCount <= maxFuel) {
            fuelCount += fuel;
            System.out.println("Актуальное количество топлива: " + fuelCount);
        } else {
            System.out.println("Превышен максимальный объём топливного бака");
        }
        return fuel * 59;
    }

    public static void main(String[] args) {
        Bus bus = new Bus(80, 500);
        bus.passengers(50);
        bus.refuel(400);
        bus.drive();
        System.out.println("------");
        bus.passengers(40);
        bus.refuel(400);
        System.out.println("------");
        bus.passengers(30);
        bus.refuel(100);
        bus.drive();
    }
}
