package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> all = tracker.findAll();
        if (all.size() > 0) {
            for (int index = 0; index < all.size(); index++) {
                out.printLn(all.get(index).toString());
            }
        } else {
            out.printLn("empty tracker");
        }
        return true;
    }

}
