package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"9", "0"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
                actions.add(new ExitAction());
        
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }

    /*@Test
    public void FindAllAction() {
    Output out = new StubOutput();
    Input in = new StubInput(
            new String[] {"0", "1"}
    );
    Tracker tracker = new Tracker();
    UserAction[] actions = {
            new ShowAllAction(out),
            new ExitAction()
    };
    new StartUI(out).init(in, tracker, actions);
    assertThat(out.toString(), is(
            "Menu." + System.lineSeparator() +
                    "0. === Show all items ===" + System.lineSeparator() +
                    "1. Exit" + System.lineSeparator() +
                    "empty tracker" + System.lineSeparator() +
                    "Menu." + System.lineSeparator() +
                    "0. === Show all items ===" + System.lineSeparator() +
                    "1. Exit" + System.lineSeparator()
    ));
    }

     Непонятно как запросить частичное совпадение в assert, т.к. дата каждый раз новая.

    @Test
    public void FindByNameAction() {
        Tracker tracker = new Tracker();
        Item item =  new Item();
        item.setName("itemName");
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "itemName", "1"}
        );

        tracker.add(item);
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find item by name ====" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Find item by name ====" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void FindMissingNameAction() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "itemName", "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find item by name ====" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "Заявки с таким именем не найдены" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Find item by name ====" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void FindByIdAction() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find item by id ====" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Impossible to find ====" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Find item by id ====" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }*/
}