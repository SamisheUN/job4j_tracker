package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI extends Item {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                /* 1.1. У объекта tracker вызвать метод findAll();
                1.2. Результат вызова поместить в переменную - это будет массив элементов класса Item;
                1.3. Вывести в консоль все элементы массива, выполнить в соответствии с примечанием 1.1.*/
                System.out.println("=== Show all items ====");
                Item[] all = tracker.findAll();
                if (all.length > 0) {
                    for (int index = 0; index < all.length; index++) {
                        System.out.println(all[index].toString());}
                    } else {
                        System.out.println("empty tracker");
                    }
            } else if (select == 2) {
                /*
                2.1. Получить id заявки, которую мы будем изменять, через объект scanner;
                2.2. Получить имя заявки на которую мы будем заменять через объект scanner;
                2.3. Создаем объект класса Item, у которого устанавливаем имя из пункта 2.2;
                2.4. Вызвать метод replace у объекта tracker, в него передать id из пункта 2.1 и объект класса Item из пункта 2.3;
                2.5. Результат работы метода replace необходимо валидировать, для этого учтите рекомендацию из примечания 2.
                 */
                System.out.println("=== Edit item ===="); //готово
                System.out.println("Enter an existing id: ");
                int replaceExistId = Integer.valueOf(scanner.nextLine());
                System.out.println("Enter new name: ");
                String replaceNewName = String.valueOf(scanner.nextLine());
                Item replaceNewItem = new Item(replaceNewName);
                boolean replaceResult = tracker.replace(replaceExistId, replaceNewItem);
                if (replaceResult) {
                    System.out.println("=== Replacement was successful ====");
                } else {
                    System.out.println("=== Impossible to replace ====");
                }
            } else if (select == 3) {
                /*3.1. Получить id заявки, которую мы будем удалять, через объект scanner;
                3.2. Вызвать метод delete у объекта tracker, в него передать id из пункта 3.1;
                3.3. Результат работы метода delete необходимо валидировать, для этого учтите рекомендацию из примечания 2.*/
                System.out.println("=== Delete item ===="); //готово
                System.out.println("Enter an existing id:");
                int deleteExistId = Integer.valueOf(scanner.nextLine());
                boolean deleteResult = tracker.delete(deleteExistId);
                if (deleteResult) {
                    System.out.println("=== Deletion was successful ====");
                } else {
                    System.out.println("=== id is negative. Impossible to delete ====");
                }
            } else if (select == 4) {
                /*4.1. Получить id заявки, которую мы будем искать в хранилище, через объект scanner;
                4.2. Вызвать метод findById() у объекта tracker, в него передать id из пункта 4.1;
                4.3. Результат вызова метода поместить в переменную - это будет объект класса Item;
                4.4. Результат работы метода findById() необходимо валидировать, поскольку метод может вернуть null;
                4.5. Если заявка не равна null -  мы печатаем в консоль заявку, иначе - фразу: "Заявка с таким id не найдена".*/
                System.out.println("=== Find item by id ====");
                System.out.println("Enter an existing id to search:");
                int wantedId = Integer.valueOf(scanner.nextLine());
                Item wantedItem = tracker.findById(wantedId);
                if (wantedItem == null) {
                    System.out.println("=== Impossible to find ====");
                } else {
                    System.out.println("Item found: ");
                    System.out.println(wantedItem.toString());
                }
            } else if (select == 5) {
                /*5.1. Получить имя заявок, которые мы будем искать, через объект scanner;
                5.2. Вызвать метод findByName() у объекта tracker, в него передать имя из пункта 1;
                5.3. Результат вызова метода поместить в переменную - это будет массив объектов класса Item;
                5.4. Результат работы метода findByName() необходимо валидировать, поскольку метод может вернуть пустой массив;
                5.5. Если длина массива больше 0 - выводим массив в соответствии с примечанием 1, иначе фразу - "Заявки с таким именем не найдены". */
                System.out.println("=== Find item by name ====");
                System.out.println("Enter an existing name to search: ");
                String wantedName = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

    /* Старое содержимое класса

    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime itemTime = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedTime = itemTime.format(formatter);
        System.out.println(formattedTime);
        Tracker tracker = new Tracker();
        tracker.add(item);
        Item founded = tracker.findById(1);
        System.out.println("Старый формат: ");
        System.out.println("native: " + founded);
        System.out.println("id:" + founded.getId());
        System.out.println("name: " + founded.getName());
        System.out.println("date: " + founded.getCreated());
        System.out.println("Формат toString: ");
        System.out.println(item.toString());
    }*/
}
