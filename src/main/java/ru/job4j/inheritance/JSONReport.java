package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    public String generate(String name, String body) {
        String ln = System.lineSeparator();
        String sName = String.format("\"%s\"", name);
        String sBody = String.format("\"%s\"", body);
        return "{" + ln
                + "\t\"name\" : " + sName + "," + ln
                + "\t\"body\" : " + sBody + ln
                + "}";
    }
}
