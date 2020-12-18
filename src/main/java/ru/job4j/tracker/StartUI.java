package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI extends Item {

    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime itemTime = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedTime = itemTime.format(formatter);
        System.out.println(formattedTime);
    }
}
