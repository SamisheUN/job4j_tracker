package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] all = tracker.findAll();
        if (all.length > 0) {
            for (int index = 0; index < all.length; index++) {
                out.printLn(all[index].toString());
            }
        } else {
            out.printLn("empty tracker");
        }
        return true;
    }

}
