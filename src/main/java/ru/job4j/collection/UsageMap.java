package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> users = new HashMap<>();
        users.put("qwer@a.com", "Qwer");
        users.put("qwer@a.com", "Qwer");
        users.put("qwert@a.com", "Qwert");
        users.put("qwerty@a.com", "Qwerty");
        users.put("qwerty@a.com", "Qwerty");
        users.put("qwertyu@a.com", "Qwertyu");
        users.put("qwertyu@a.com", "Qwertyu");
        users.put("qwertyu@a.com", "Qwertyu");
        for (String key : users.keySet()) {
            System.out.println("Email: " + key + " -> Username: "  + users.get(key));
        }
    }
}
