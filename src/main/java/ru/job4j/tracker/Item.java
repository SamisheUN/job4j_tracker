package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.util.Objects;

public class Item implements Comparable<Item> {
    private final LocalDateTime created = LocalDateTime.now();
    private int id;
    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name='"
                + name + '\''
                + ", created=" + created + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public int compareTo(Item another) {
        return CharSequence.compare(name, another.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(id, item.id)
                && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}