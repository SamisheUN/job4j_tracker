package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.bank.User;
import ru.job4j.bank.UserNameAgeComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenSortDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("b", 1),
                new Job("a", 1),
                new Job("z", 1),
                new Job("z", 12)
        );
        Collections.sort(jobs, new JobDescByName());
        assertEquals(jobs, Arrays.asList(
                new Job("z", 1),
                new Job("z", 12),
                new Job("b", 1),
                new Job("a", 1)
                )
        );
    }

    @Test
    public void whenSortDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("bb", 3),
                new Job("d", 2),
                new Job("ccc", 4),
                new Job("aaaa", 1)
        );
        Collections.sort(jobs, new JobDescByPriority());
        assertEquals(jobs, Arrays.asList(
                new Job("ccc", 4),
                new Job("bb", 3),
                new Job("d", 2),
                new Job("aaaa", 1)
                )
        );
    }

    @Test
    public void whenSortAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("b", 1),
                new Job("a", 1),
                new Job("z", 1),
                new Job("z", 12)
        );
        Collections.sort(jobs, new JobAscByName());
        assertEquals(jobs, Arrays.asList(
                new Job("a", 1),
                new Job("b", 1),
                new Job("z", 1),
                new Job("z", 12)
                )
        );
    }

    @Test
    public void whenSortAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("bb", 3),
                new Job("d", 2),
                new Job("ccc", 4),
                new Job("aaaa", 1)
        );
        Collections.sort(jobs, new JobAscByPriority());
        assertEquals(jobs, Arrays.asList(
                new Job("aaaa", 1),
                new Job("d", 2),
                new Job("bb", 3),
                new Job("ccc", 4)
                )
        );
    }

    @Test
    public void whenCompByDescNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByDescNameAndAscPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("a", 0),
                new Job("a", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenSortAscByPriorityDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("b", 2),
                new Job("a", 1),
                new Job("a", 2),
                new Job("b", 1)
        );
        Collections.sort(jobs, new JobAscByPriority().thenComparing(new JobDescByName()));
        assertEquals(jobs, Arrays.asList(
                new Job("b", 1),
                new Job("a", 1),
                new Job("b", 2),
                new Job("a", 2)
                )
        );
    }
}