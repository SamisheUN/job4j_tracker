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
        Tracker tracker = new Tracker();
        tracker.add(item);
        Item founded = tracker.findById(1);
        System.out.println("native: " + founded);
        System.out.println("id:" + founded.getId());
        System.out.println("name: " + founded.getName());
        System.out.println("date: " + founded.getCreated());
    }
}
