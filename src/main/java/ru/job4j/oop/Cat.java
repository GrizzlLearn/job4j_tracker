package ru.job4j.oop;

public class Cat {

    String meal;
    String name;

    public void meal(String meal) {
        this.meal = meal;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println("Имя котика: " + this.name);
        System.out.println(this.name + " кушал: " + this.meal);
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        Cat black = new Cat();
        gav.meal("kotleta");
        gav.giveNick("Gav");
        black.meal("fish");
        black.giveNick("Black");
        gav.show();
        System.out.println("---");
        black.show();
    }
}
