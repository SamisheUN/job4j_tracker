package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ItemSortTest {
   /* @Test
    public void whenTwo() {
        Item itemOne = new Item(1, "z");
        Item itemTwo = new Item(2, "a");
        assertEquals(SortItemDescrOrder.compare(itemOne, itemTwo), 1);
    }*/

    @Test
    public void whenReverse() {
        List<Item> items = Arrays.asList(
                new Item(1, "a"),
                new Item(3, "c"),
                new Item(4, "d"),
                new Item(2, "b")
        );
        Collections.sort(items, new SortItemDescrOrder());
        assertEquals(items, Arrays.asList(
                        new Item(4, "d"),
                        new Item(3, "c"),
                        new Item(2, "b"),
                        new Item(1, "a")
                )
        );
    }

    @Test
    public void whenNormalOrder() {
        List<Item> items = Arrays.asList(
                new Item(1, "a"),
                new Item(3, "c"),
                new Item(4, "d"),
                new Item(2, "b")
        );
        Collections.sort(items, new SortItemIncrOrder());
        assertEquals(items, Arrays.asList(
                new Item(1, "a"),
                new Item(2, "b"),
                new Item(3, "c"),
                new Item(4, "d")
                )
        );
    }

}
