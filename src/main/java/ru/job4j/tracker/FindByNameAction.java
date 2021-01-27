package ru.job4j.tracker;

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
        Item[] searchingResult = tracker.findByName(wantedName);
        if (searchingResult.length > 0) {
            for (int index = 0; index < searchingResult.length; index++) {
                out.printLn(searchingResult[index].toString());
            }
        } else {
            out.printLn("Заявки с таким именем не найдены");
        }
        return true;
    }
}