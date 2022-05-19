package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
            for (int i = 0; i < value.length; i++) {
                    if (key.equals(value[i])) {
                        rsl = i;
                        break;
                    }
            }
            if (rsl == -1) {
                throw new ElementNotFoundException("Don`t find key element");
            }
        return rsl;
    }

    public static void main(String[] args) {
        String[] in = new String[] {"a", "b", "c", "z"};
        String key = "d";
        try {
            System.out.println(indexOf(in, key));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

    }
}
