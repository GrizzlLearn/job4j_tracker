package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                rsl = items[i];
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String name) {
        Item[] rsl = new Item[size];
        int tmp = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getName() != null && item.getName().equals(name)) {
                rsl[tmp] = item;
                tmp++;
            }
        }
        return Arrays.copyOf(rsl, tmp);
    }

    public Item[] findAll() {
        Item[] rsl = new Item[size];
        int tmp = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName() != null) {
                rsl[tmp] = items[i];
                tmp++;
            }
        }
        return Arrays.copyOf(rsl, tmp);
    }
}
