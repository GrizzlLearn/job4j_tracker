package ru.job4j.poly;

public class Traffic {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane(200);
        Vehicle airplane1 = new Airplane(210);
        Vehicle train = new Train(1000);
        Vehicle train1 = new Train(800);
        Vehicle intercityBus = new IntercityBus(100);
        Vehicle intercityBus1 = new IntercityBus(120);
        Vehicle[] vehicles = new Vehicle[]{airplane, airplane1, train, train1, intercityBus, intercityBus1};
        for (Vehicle vehicle : vehicles) {
            vehicle.passengers();
            vehicle.move();
            System.out.println("----");
        }
    }
}
