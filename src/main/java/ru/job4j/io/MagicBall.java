package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

     public static class Answer {
         public int random() {
             return new Random().nextInt(3);
         }

         public String magicAnswer(String question) {
            if (random() == 0) {
                return "Ответ на твой вопрос: " + question + " -> Да";
            } else if (random() == 1) {
                return "Ответ на твой вопрос: " + question + " -> Нет";
            } else {
                return "Ответ на твой вопрос: " + question + " -> Может быть";
            }
         }
     }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        Answer answer = new Answer();
        System.out.println(answer.magicAnswer(input.nextLine()));
    }
}

