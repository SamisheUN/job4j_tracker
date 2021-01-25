package ru.job4j.tracker;

public class EditItemAction implements UserAction{
    private final Output out;

    public EditItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int replaceExistId = input.askInt("Enter an existing id: ");
        String replaceNewName = input.askStr("Enter new name: ");
        Item replaceNewItem = new Item(replaceNewName);
        boolean replaceResult = tracker.replace(replaceExistId, replaceNewItem);
        if (replaceResult) {
            out.printLn("=== Replacement was successful ====");
        } else {
            out.printLn("=== Impossible to replace ====");
        }
        return true;
    }
}