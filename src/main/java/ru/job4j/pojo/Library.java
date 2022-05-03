package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 464);
        Book book2 = new Book("Град обреченный", 408);
        Book book3 = new Book("Первый Закон", 1671);
        Book book4 = new Book("Тёмная Башня", 4316);

        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName());
        }

        System.out.println("---");

        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName());
        }

        System.out.println("---");

        for (Book book: books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println("Название: " + book.getName() + ". Количество страниц: " + book.getPageCount() + ".");
            }
        }
    }
}
