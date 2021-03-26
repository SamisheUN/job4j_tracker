package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class FindByNameAction implements UserAction{
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }


    @Override
    public String name() {
        return "=== Find item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String wantedName = input.askStr("Enter an existing name to search: ");
        ArrayList<Item> searchingResult = tracker.findByName(wantedName);
        if (searchingResult.size() > 0) {
            for (int index = 0; index < searchingResult.size(); index++) {
                out.printLn(searchingResult.get(index).toString());
            }
        } else {
            out.printLn("Заявки с таким именем не найдены");
        }
        return true;
    }
}