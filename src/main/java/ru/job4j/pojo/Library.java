package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book();
        Book second = new Book();
        Book third = new Book();
        Book fourth = new Book();
        Book[] books = new Book[4];
        first.setName("One");
        first.setPages(213);
        second.setName("marlin code");
        second.setPages(215);
        third.setName("Clean code");
        third.setPages(556);
        fourth.setName("Four");
        fourth.setPages(214);
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = fourth;
        System.out.println("Печать полного массива: ");
        for (int i = 0; i<books.length; i++) {
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
        for (int i = 0; i<books.length; i++) {
            Book book = books[i];
            if (book.getName() == "Clean code") {
                System.out.println(book.getName());
            }
        }
    }
}
