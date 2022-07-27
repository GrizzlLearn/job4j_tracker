package ru.job4j.stream;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student> input = new ArrayList<>();
        input.add(new Student(28, "Masha"));
        input.add(new Student(128, "Petya"));
        List<Student> expected = List.of(
                new Student(128, "Petya"),
                new Student(28, "Masha")
        );
        assertThat(StudentLevel.levelOf(input, 20)).isEqualTo(expected);
    }

    @Test
    public void whenOnlyNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        List<Student> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 100)).isEqualTo(expected);
    }

    @Test
    public void whenHasNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        input.add(new Student(28, "Petya"));
        List<Student> expected = List.of(new Student(28, "Petya"));
        assertThat(StudentLevel.levelOf(input, 10)).isEqualTo(expected);
    }
}
