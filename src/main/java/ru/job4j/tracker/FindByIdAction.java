package ru.job4j.tracker;

public class FindByIdAction implements UserAction{
    @Override
    public String name() {
        return "=== Find item by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int wantedId = input.askInt("Enter an existing id to search:");
        Item wantedItem = tracker.findById(wantedId);
        if (wantedItem == null) {
            System.out.println("=== Impossible to find ====");
        } else {
            System.out.println("Item found: ");
            System.out.println(wantedItem.toString());
        }
        return true;
    }
}