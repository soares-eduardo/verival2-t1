package com.eduardojoao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FatorialTest {
    
    Numero num;
    Somador som;
    Multiplicador multi;

    @BeforeEach
    void setUp() {
        Somador somador = mock(Somador.class);
    }


    Fatorial fat;

    @Test
    public void fatorial1() {
        num = new Numero(-1);
        som = new Somador();
        som.set(num);
        multi = new Multiplicador(som);
        fat = new Fatorial(multi);
        fat.fatorial(fat.resultado());
        assertEquals(null, fat.resultado());
    }

    @Test
    public void fatorial2() {
        num = new Numero(0);
        som = new Somador();
        som.set(num);
        multi = new Multiplicador(som);
        fat = new Fatorial(multi);
        fat.fatorial(fat.resultado());
        assertEquals(1, fat.resultado().valor());
    }

    @Test
    public void fatorial3() {
        num = new Numero(8);
        som = new Somador();
        som.set(num);
        multi = new Multiplicador(som);
        fat = new Fatorial(multi);
        fat.fatorial(fat.resultado());
        assertEquals(40320, fat.resultado().valor());
    }
}
