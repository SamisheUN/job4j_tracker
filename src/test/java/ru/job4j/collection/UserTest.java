package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.bank.User;
import ru.job4j.bank.UserNameAgeComparator;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SortItemIncrOrder;

import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Z", 9000));
        users.add(new User("Petr", 32));
        users.add(new User("Z", 9001));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
        assertThat(it.next(), is(new User("Z", 9000)));
        assertThat(it.next(), is(new User("Z", 9001)));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareOneNameDiffAge() {
        int rsl = new User("A", 1)
                .compareTo(
                        new User("A", 2)
                );
        assertThat(rsl, is(-1));
    }

    @Test
    public void whenCompareOneNameOneAge() {
        int rsl = new User("A", 1)
                .compareTo(
                        new User("A", 1)
                );
        assertThat(rsl, is(0));
    }

    @Test
    public void whenNormalOrderComparatorTest() {
        List<User> users = Arrays.asList(
                new User("b", 1),
                new User("a", 1),
                new User("z", 1),
                new User("z", 12)
        );
        Collections.sort(users, new UserNameAgeComparator());
        assertEquals(users, Arrays.asList(
                new User("a", 1),
                new User("b", 1),
                new User("z", 1),
                new User("z", 12)
                )
        );
    }
}