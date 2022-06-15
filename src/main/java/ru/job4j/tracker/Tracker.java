package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (Item item : items) {
            if (item != null && item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public List<Item> findByName(String name) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(name)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    public List<Item> findAll() {
        return items;
    }

    public boolean replace(int id, Item item) {
        int index = items.indexOf(findById(id));
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = items.indexOf(findById(id));
        boolean rsl = index != -1;
        if (rsl) {
            items.set(index, null);
        }
        return rsl;
    }
}
