package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    private final Output out;

    public DeleteItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int deleteExistId = input.askInt("Enter an existing id:");
        boolean deleteResult = tracker.delete(deleteExistId);
        if (deleteResult) {
            out.printLn("=== Deletion was successful ====");
        } else {
            out.printLn("=== id is negative. Impossible to delete ====");
        }
        return true;
    }
}