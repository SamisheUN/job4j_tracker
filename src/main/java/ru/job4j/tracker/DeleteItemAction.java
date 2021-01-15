package ru.job4j.tracker;

public class DeleteItemAction implements UserAction{
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int deleteExistId = input.askInt("Enter an existing id:");
        boolean deleteResult = tracker.delete(deleteExistId);
        if (deleteResult) {
            System.out.println("=== Deletion was successful ====");
        } else {
            System.out.println("=== id is negative. Impossible to delete ====");
        }
        return true;
    }
}