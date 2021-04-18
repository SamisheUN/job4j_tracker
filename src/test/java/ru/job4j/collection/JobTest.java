package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.bank.User;
import ru.job4j.bank.UserNameAgeComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JobTest {
    //далее 3 теста одиночных компараторов, далее - множественные
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
    public void whenSortDescByNameLngth() {
        List<Job> jobs = Arrays.asList(
                new Job("bb", 1),
                new Job("d", 1),
                new Job("ccc", 1),
                new Job("aaaa", 1)
        );
        Collections.sort(jobs, new JobDescByNameLn());
        assertEquals(jobs, Arrays.asList(
                new Job("aaaa", 1),
                new Job("ccc", 1),
                new Job("bb", 1),
                new Job("d", 1)
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
    public void whenSortNameAndDscndNameLgth() {
        List<Job> jobsSortedByThen = Arrays.asList(
                new Job("bb", 3),
                new Job("d", 2),
                new Job("ccc", 4),
                new Job("aaaa", 1)
        );
        List<Job> jobsSortedBySingle = jobsSortedByThen;
        Collections.sort(jobsSortedByThen, new JobDescByName().thenComparing(new JobDescByNameLn()));
        Collections.sort(jobsSortedBySingle, new JobSortByNameAndDscndNameLngth());
        assertEquals(jobsSortedBySingle, jobsSortedByThen);
    }

    @Test
    public void whenSortNameAndAscndNameLgth() {
        List<Job> jobsSortedByThen = Arrays.asList(
                new Job("bb", 3),
                new Job("d", 2),
                new Job("ccc", 4),
                new Job("aaaa", 1)
        );
        List<Job> jobsSortedBySingle = jobsSortedByThen;
        Collections.sort(jobsSortedByThen, new JobDescByName().thenComparing(new JobDescByNameLn().reversed()));
        Collections.sort(jobsSortedBySingle, new JobSortByNameAndDscndNameLngth());
        assertEquals(jobsSortedBySingle, jobsSortedByThen);
    }

    @Test
    public void whenSortPriorAndDscndNameLgth() {
        List<Job> jobsSortedByThen = Arrays.asList(
                new Job("bb", 3),
                new Job("d", 2),
                new Job("ccc", 4),
                new Job("aaaa", 1)
        );
        List<Job> jobsSortedBySingle = jobsSortedByThen;
        Collections.sort(jobsSortedByThen, new JobDescByPriority().thenComparing(new JobDescByNameLn()));
        Collections.sort(jobsSortedBySingle, new JobSortByPriorAndDscndNameLngth());
        assertEquals(jobsSortedBySingle, jobsSortedByThen);
    }

    @Test
    public void whenSortPriorAndAscndNameLgth() {
        List<Job> jobsSortedByThen = Arrays.asList(
                new Job("bb", 3),
                new Job("d", 2),
                new Job("ccc", 4),
                new Job("aaaa", 1)
        );
        List<Job> jobsSortedBySingle = jobsSortedByThen;
        Collections.sort(jobsSortedByThen, new JobDescByPriority().thenComparing(new JobDescByNameLn().reversed()));
        Collections.sort(jobsSortedBySingle, new JobSortByPriorAndAscndNameLngth());
        assertEquals(jobsSortedBySingle, jobsSortedByThen);
    }
}