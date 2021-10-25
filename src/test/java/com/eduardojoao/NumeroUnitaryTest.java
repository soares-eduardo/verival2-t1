package com.eduardojoao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumeroUnitaryTest {

    Numero underTest;

    @Test
    void itShouldIncrementAPositiveNumber() { //TDD test style
        // given
        underTest = new Numero(20);

        // where
        underTest.inc();

        // then
        assertEquals(21, underTest.valor());
    }

    @Test
    void itShouldIncrementANegativeNumber() {
        // given
        underTest = new Numero(-20);

        // where
        underTest.inc();

        // then
        assertEquals(-19, underTest.valor());
    }

    @Test
    void itShouldDecrementAPositiveNumber() {
        // given
        underTest = new Numero(300);

        // where
        underTest.dec();

        // then
        assertEquals(299, underTest.valor());
    }

    @Test
    void itShouldDecrementANegativeNumber() {
        // given
        underTest = new Numero(-50);

        // where
        underTest.dec();

        // then
        assertEquals(-51, underTest.valor());
    }
}
