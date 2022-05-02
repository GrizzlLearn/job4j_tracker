package ru.job4j.tracker;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item(0, "first");
        System.out.println(item.getCreated());
    }
}
