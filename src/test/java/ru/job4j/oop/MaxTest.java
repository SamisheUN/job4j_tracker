package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax2To1Then2() {
        int result = Max.max(2, 1, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax5To5Then5() {
        int result = Max.max(5, 5, 6, 7);
        assertThat(result, is(7));
    }
}
