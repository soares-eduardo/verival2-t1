package com.eduardojoao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SomadorTest {

    Somador underTest;
    Numero numero1;
    Numero numero2;

    @BeforeEach
    void setUp() {
        underTest = new Somador();
    }

    @Test
    void itShouldSumAPositiveNumberWithANegativeNumber() {

        // given

        numero1 = new Numero(4);
        numero2 = new Numero(-4);

        // when

        underTest.set(numero1);
        underTest.mais(numero2);

        // then

        assertEquals(8, underTest.resultado().valor());
    }

    @Test
    void itShouldSumANegativeNumberWithAPositiveNumber() {

        // given

        numero1 = new Numero(4);
        numero2 = new Numero(-4);

        // when

        underTest.set(numero1);
        underTest.mais(numero2);

        // then

        assertEquals(8, underTest.resultado().valor());
    }

    @Test
    void itShouldSumTwoPositiveNumbers() {

        // given

        numero1 = new Numero(378);
        numero2 = new Numero(4568);

        // when

        underTest.set(numero1);
        underTest.mais(numero2);

        // then

        assertEquals(4946, underTest.resultado().valor());
    }

    @Test
    void itShouldSubtractAPositiveNumberByANegativeNumber() {

        // given

        numero1 = new Numero(4);
        numero2 = new Numero(-4);

        // when

        underTest.set(numero1);
        underTest.menos(numero2);

        // then

        assertEquals(0, underTest.resultado().valor());
    }

    @Test
    void itShouldSubtractANegativeNumberByAPositiveNumber() {

        // given

        numero1 = new Numero(-4);
        numero2 = new Numero(3);

        // when

        underTest.set(numero1);
        underTest.menos(numero2);

        // then

        assertEquals(-7, underTest.resultado().valor());
    }

    @Test
    void itShouldSubtractTwoPositiveNumbers() {

        // given

        numero1 = new Numero(378);
        numero2 = new Numero(4568);

        // when

        underTest.set(numero1);
        underTest.menos(numero2);

        // then

        assertEquals(-4190, underTest.resultado().valor());
    }
}
