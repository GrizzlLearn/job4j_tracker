package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int random = new Random().nextInt(3);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        if (random == 0) {
            System.out.println("Ответ на твой вопрос: " + question + " -> Да");
        } else if (random == 1) {
            System.out.println("Ответ на твой вопрос: " + question + " -> Нет");
        } else {
            System.out.println("Ответ на твой вопрос: " + question + " -> Может быть");
        }
    }
}
