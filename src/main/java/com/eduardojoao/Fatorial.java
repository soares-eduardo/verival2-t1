package com.eduardojoao;

import java.util.logging.Logger;

public class Fatorial {
    
    Multiplicador resultado;
    Logger logger = Logger.getLogger("log");

    public Fatorial(Multiplicador multiplicador){
        this.resultado = multiplicador;
    }

    public Fatorial fatorial(Numero valor){
        //seta 1 como resultado para auxiliar as multiplicacoes.
        resultado = resultado.set(new Numero(1));

        if(valor.valor()<0){
            //numero negativo nao tem fatorial por definicao, operacao invalida.
            logger.warning("Numero negativo nao tem fatorial, operacao invalida.");
            resultado = resultado.set(null);
            return this;
        }
        else if(valor.valor()<2){
            //se entrou aqui é porque o valor é 0 ou 1, e ambos tem fatorial 1, portanto retorna 1.
            return this;
        }

        //faz fatorial
        //multiplica o valor pelo resultado e decrementa até o valor ser 0...
        Numero val;
        while(valor.valor()>0){
            val=valor.duplica();
            resultado.vezes(val);
            valor.dec();
        }
        String info = "resultado final:"+resultado.resultado(); 
        logger.info(info);

        return this;
    }

    public Numero resultado(){
        return resultado.resultado();
    }

}