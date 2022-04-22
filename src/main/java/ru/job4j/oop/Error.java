package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void info() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 1, "gg");
        Error error3 = new Error(false, 2, "gg wp");
        Error error4 = new Error(true, 3, "gg wp, we lost");

        error1.info();
        System.out.println("---");
        error2.info();
        System.out.println("---");
        error3.info();
        System.out.println("---");
        error4.info();

    }
}
