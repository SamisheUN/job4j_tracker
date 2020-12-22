package ru.job4j.pojo;

public class Book {
    private String name = "empty place";
    private int pages = 0;

    public Book(int pages, String name) {
        this.name = name;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }




}
