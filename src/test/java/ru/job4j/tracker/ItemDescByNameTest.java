package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemDescByNameTest {

    @Test
    public void sortDescTest() {
        List<Item> items = new ArrayList<>() {{
            add(new Item("111"));
            add(new Item("222"));
            add(new Item("555"));
            add(new Item("444"));
            add(new Item("333"));
        }};

        Collections.sort(items, new ItemDescByName());

        List<Item> expected = new ArrayList<>() {{
            add(new Item("555"));
            add(new Item("444"));
            add(new Item("333"));
            add(new Item("222"));
            add(new Item("111"));

        }};
        assertThat(items).isEqualTo(expected);
    }
}
