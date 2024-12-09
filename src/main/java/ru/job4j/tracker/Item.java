package ru.job4j.tracker;

import lombok.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Data
public class Item {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now().withNano(0);

    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", name='" + name
                + '\''
                + ", created=" + created.format(FORMATTER)
                + '}';
    }
}
