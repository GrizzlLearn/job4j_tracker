package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> users = new HashMap<>();
        users.put("qwer@a.com", "Qwer");
        users.put("qwert@a.com", "Qwert");
        users.put("qwerty@a.com", "Qwerty");
        users.put("qwertyu@a.com", "Qwertyu");
        for (Map.Entry<String, String> entry : users.entrySet()) {
            System.out.println("Email: " + entry.getKey() + " -> Username: "  + entry.getValue());
        }
    }
}
