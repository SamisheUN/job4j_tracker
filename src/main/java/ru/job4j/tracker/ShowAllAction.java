package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] all = tracker.findAll();
        if (all.length > 0) {
            for (int index = 0; index < all.length; index++) {
                System.out.println(all[index].toString());
            }
        } else {
            System.out.println("empty tracker");
        }
        return true;
    }

}
