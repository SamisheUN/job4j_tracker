package ru.job4j.tracker;

public class FindByNameAction implements UserAction{
    @Override
    public String name() {
        return "=== Find item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name");
        String wantedName = input.askStr("Enter an existing name to search: ");
        Item[] searchingResult = tracker.findByName(wantedName);
        if (searchingResult.length > 0) {
            for (int index = 0; index < searchingResult.length; index++) {
                System.out.println(searchingResult[index].toString());
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}