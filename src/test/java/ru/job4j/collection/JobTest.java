package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorJobDescByName() {
        Comparator<Job> descByName = new JobDescByName();
        int rsl = descByName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorJobAscByName() {
        Comparator<Job> ascByName = new JobAscByName();
        int rsl = ascByName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(1));
    }

    @Test
    public void whenComparatorJobDescByPriority() {
        Comparator<Job> descByPriority = new JobDescByPriority();
        int rsl = descByPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorJobAscByPriority() {
        Comparator<Job> ascByPriority = new JobAscByPriority();
        int rsl = ascByPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorJobDescByNameLn() {
        Comparator<Job> descByNameLn = new JobDescByNameLn();
        int rsl = descByNameLn.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorJobAscByNameThenJobAscByPriority() {
        Comparator<Job> comb = new JobAscByName()
                .thenComparing(new JobDescByNameLn())
                .thenComparing(new JobDescByPriority());
        int rsl = comb.compare(
                new Job("ccccc", 121),
                new Job("dd", 12)
        );
        assertThat(rsl, lessThan(0));
    }
}
