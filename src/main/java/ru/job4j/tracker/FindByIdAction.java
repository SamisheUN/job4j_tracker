package ru.job4j.tracker;

public class FindByIdAction implements UserAction{
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }


    @Override
    public String name() {
        return "=== Find item by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int wantedId = input.askInt("Enter an existing id to search:");
        Item wantedItem = tracker.findById(wantedId);
        if (wantedItem == null) {
            out.printLn("=== Impossible to find ====");
        } else {
            out.printLn("Item found: ");
            out.printLn(wantedItem.toString());
        }
        return true;
    }
}