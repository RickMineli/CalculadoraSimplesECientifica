package com.github.rickmineli.calculadoraapi.model;

public enum Operacao {

    SOMA {
        @Override
        public Double executarOperacao(Double numeroUm, Double numeroDois) {
            return numeroUm + numeroDois;
        }
    },
    SUBTRACAO {
        @Override
        public Double executarOperacao(Double numeroUm, Double numeroDois) {
            return numeroUm - numeroDois;
        }
    },
    MULTIPLICACAO {
        @Override
        public Double executarOperacao(Double numeroUm, Double numeroDois) {
            return numeroUm * numeroDois;
        }
    },
    DIVISAO {
        @Override
        public Double executarOperacao(Double numeroUm, Double numeroDois) {
            return numeroUm / numeroDois;
        }
    };


    public abstract Double executarOperacao(Double numeroUm, Double numeroDois);

}
