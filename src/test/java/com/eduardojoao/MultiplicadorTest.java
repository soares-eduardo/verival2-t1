package com.eduardojoao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MultiplicadorTest {

    private Numero numero;
    private Somador somador;
    private Multiplicador multiplicador;

    @BeforeEach
    public void setup() {
        this.numero = new Numero(100);
        this.somador = new Somador();
    }

    @Test
    public void vezesZeroTest() {
        // given
        Numero zero = new Numero(0);
        somador.set(numero);
        this.multiplicador = new Multiplicador(somador);
        // where
        Multiplicador result = multiplicador.vezes(zero);
        // then
        assertEquals(zero.valor(), result.resultado().valor());
    }

    @Test
    public void vezesComSinalDiferenteTest() {
         // given
         Numero numeroNegativo = new Numero(-10);
         Numero numeroPositivo = new Numero(10);
         Numero numeroExperado = new Numero(-100);
         // where
         somador.set(numeroNegativo);
         this.multiplicador = new Multiplicador(somador);
         Multiplicador result = multiplicador.vezes(numeroPositivo);
         // then
         assertEquals(numeroExperado.valor(), result.resultado().valor());
    }

    @Test
    public void vezesComSinalIgualTest() {
        // given
        Numero numeroInicial = new Numero(10);
        Numero numeroPositivo = new Numero(10);
        Numero numeroExperado = new Numero(100);
        // where
        somador.set(numeroInicial);
        this.multiplicador = new Multiplicador(somador);
        Multiplicador result = multiplicador.vezes(numeroPositivo);
        // then
        assertEquals(numeroExperado.valor(), result.resultado().valor());
    }

    @Test
    public void divididoPorZeroTest() {
        // given
        Numero zero = new Numero(0);
        somador.set(numero);
        this.multiplicador = new Multiplicador(somador);
        // where
        Multiplicador result = multiplicador.dividido(zero);
        // then
        assertNull(result.resultado());
    }

    @Test
    public void divididoZeroPorZeroTest() {
        // given
        Numero zero = new Numero(0);
        somador.set(zero);
        this.multiplicador = new Multiplicador(somador);
        // where
        Multiplicador result = multiplicador.dividido(numero);
        // then
        assertEquals(0, result.resultado().valor());
    }

    @Test
    public void divididoComSinalDiferenteTest() {
         // given
         Numero numeroNegativo = new Numero(-10);
         Numero numeroPositivo = new Numero(10);
         Numero numeroExperado = new Numero(-1);
         // where
         somador.set(numeroNegativo);
         this.multiplicador = new Multiplicador(somador);
         Multiplicador result = multiplicador.dividido(numeroPositivo);
         // then
         assertEquals(numeroExperado.valor(), result.resultado().valor());
    }

    @Test
    public void divididoComSinalIgualTest() {
        // given
        Numero numeroInicial = new Numero(10);
        Numero numeroPositivo = new Numero(10);
        Numero numeroExperado = new Numero(1);
        // where
        somador.set(numeroInicial);
        this.multiplicador = new Multiplicador(somador);
        Multiplicador result = multiplicador.dividido(numeroPositivo);
        // then
        assertEquals(numeroExperado.valor(), result.resultado().valor());
    }
}