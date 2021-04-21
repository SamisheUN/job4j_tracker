package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book(200, "One");
        Book second = new Book(300, "Bambook");
        Book third = new Book(323, "Clean code");
        Book fourth = new Book(999, "Da Fish");
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = fourth;
        System.out.println("Печать полного массива: ");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("Печать массива после взаимозамены 0 и 3: ");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName());
        }
        System.out.println("Печать фильтрованного массива: ");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName());
            }
        }
    }
}
