package com.eduardojoao;

import java.util.logging.Logger;

public class Multiplicador {
    private Somador resultado;
    Logger logger = Logger.getLogger("log");

    public Multiplicador(Somador somador){
        this.resultado = somador;
    }

    public Multiplicador set(Numero valor){
        this.resultado = this.resultado.set(valor);
        return this;
    }

    public Multiplicador vezes(Numero outro){
        if(outro.valor()==0 || resultado.resultado().valor()==0){
            //se um dos dois for 0, a resposta é zero porque 0*n=0
            resultado = resultado.set(new Numero(0));
            return this;
        }
        //nas proximas 4 linhas descobre e armazena a informacao de valor positivo ou negativo dos numeros
        boolean sinalDiferente = sinalDiferente(outro);

        //transforma os dois valores em positivo para multiplicar com o while
        resultado = resultado.set(resultado.resultado().abs());
        outro = outro.abs();

        //multiplica
        Numero res = new Numero(resultado.resultado().valor());
        while(outro.valor()>1){
            resultado.mais(res);
            outro.dec();
        }

        //se os sinais forem diferentes, o resultado era pra ser negativo, entao transforma em negativo
        if(sinalDiferente){
            resultado = resultado.set(new Numero(-resultado.resultado().valor()));
        }
        return this;
    }

    public Multiplicador dividido(Numero outro){
        if(outro.valor()==0){
            //divisao por 0 é indefinido, operacao invalida.
            logger.warning("Divisao por 0, invalido!");
            resultado=resultado.set(null);
            return this;
        }
        if(resultado.resultado().valor()==0){
            //se o numero a ser divido for 0, o resultado é 0.
            resultado = resultado.set(new Numero(0));
            return this;
        }
        //nas proximas 4 linhas descobre e armazena a informacao de valor positivo ou negativo dos numeros
        boolean sinalDiferente = sinalDiferente(outro);

        //transforma os dois valores em positivo para multiplicar com o while
        resultado = resultado.set(resultado.resultado().abs());
        outro = outro.abs();

        //divide
        //cria um count que conta quantas vezes podemos subtrair outro de resultado e o armazena como resultado.
        Numero count = new Numero(0);
        while(resultado.resultado().valor() >= outro.valor()){
            count.inc();
            resultado.menos(outro);
        }
        resultado = resultado.set(new Numero(count.valor()));

        //se os sinais forem diferentes, o resultado era pra ser negativo, entao transforma em negativo
        if(sinalDiferente   ){
            resultado = resultado.set(new Numero(-resultado.resultado().valor()));
        }
        return this;
    }

    public Numero resultado(){
        return resultado.resultado();
    }

    public boolean sinalDiferente(Numero numero) {
        boolean resultadoPos = (resultado.resultado().valor() >= 0);
        boolean outroPos = (numero.valor() >= 0);
        return resultadoPos != outroPos;
    }

}