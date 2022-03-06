package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenLessThatThen0() {
        Fact.calc(-1);
    }

    @Test
    public void when6then720() {
        int rsl = Fact.calc(6);
        assertThat(rsl, is(720));
    }
}