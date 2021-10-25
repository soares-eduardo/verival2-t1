package com.eduardojoao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FatorialTest {
    Fatorial fatorial;

    @BeforeEach
    void setUp() {
        Numero numero = new Numero(10);
        Somador somador = new Somador();
        somador.set(numero);
        Multiplicador multiplicador = new Multiplicador(somador);
        this.fatorial = new Fatorial(multiplicador);
    }    

    @Test
    void fatorialNumeroNegativoTest() {
        // given
        Numero numeroNegativo = new Numero(-10);
        // where
        Fatorial result = this.fatorial.fatorial(numeroNegativo);
        // then
        assertNull(result.resultado());
    }
    
    @Test
    void fatorialDeUmTest() {
        // given
        Numero numeroZero = new Numero(0);
        Numero numeroUm = new Numero(1);
        // where
        Fatorial resultZero = this.fatorial.fatorial(numeroZero);
        Fatorial resultUm = this.fatorial.fatorial(numeroUm);
        // then
        assertEquals(1, resultZero.resultado().valor());
        assertEquals(1, resultUm.resultado().valor());
    }

    @Test
    void fatorialTest() {
        // given
        Numero numero = new Numero(5);
        // where
        Fatorial result = this.fatorial.fatorial(numero);
        // then
        assertEquals(120, result.resultado().valor());
    }

}
