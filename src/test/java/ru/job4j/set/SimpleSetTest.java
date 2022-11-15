package ru.job4j.set;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SimpleSetTest {

    @Test
    void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(1)).isTrue();
        assertThat(set.contains(1)).isTrue();
        assertThat(set.add(1)).isFalse();
    }

    @Test
    void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(null)).isTrue();
        assertThat(set.contains(null)).isTrue();
        assertThat(set.add(null)).isFalse();
    }

    @Test
    void whenAddEmptyString() {
        Set<String> set = new SimpleSet<>();
        assertThat(set.add("one")).isTrue();
        assertThat(set.add("")).isTrue();
        assertThat(set.contains("")).isTrue();
        assertThat(set.add("")).isFalse();
    }
}