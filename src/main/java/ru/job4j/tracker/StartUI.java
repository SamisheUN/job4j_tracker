package ru.job4j.tracker;

public class StartUI extends Item {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] all = tracker.findAll();
                if (all.length > 0) {
                    for (int index = 0; index < all.length; index++) {
                        System.out.println(all[index].toString());}
                    } else {
                        System.out.println("empty tracker");
                    }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                int replaceExistId = input.askInt("Enter an existing id: ");
                String replaceNewName = String.valueOf(input.askInt("Enter new name: "));
                Item replaceNewItem = new Item(replaceNewName);
                boolean replaceResult = tracker.replace(replaceExistId, replaceNewItem);
                if (replaceResult) {
                    System.out.println("=== Replacement was successful ====");
                } else {
                    System.out.println("=== Impossible to replace ====");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                int deleteExistId = input.askInt("Enter an existing id:");
                boolean deleteResult = tracker.delete(deleteExistId);
                if (deleteResult) {
                    System.out.println("=== Deletion was successful ====");
                } else {
                    System.out.println("=== id is negative. Impossible to delete ====");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ====");
                int wantedId = input.askInt("Enter an existing id to search:");
                Item wantedItem = tracker.findById(wantedId);
                if (wantedItem == null) {
                    System.out.println("=== Impossible to find ====");
                } else {
                    System.out.println("Item found: ");
                    System.out.println(wantedItem.toString());
                }
            } else if (select == 5) {
                System.out.println("=== Find item by name ====");
                String wantedName = input.askStr("Enter an existing name to search: ");
                Item[] searchingResult = tracker.findByName(wantedName);
                if (searchingResult.length > 0) {
                    for (int index = 0; index < searchingResult.length; index++) {
                        System.out.println(searchingResult[index].toString());}
                    } else {
                        System.out.println("Заявки с таким именем не найдены");
                    }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
