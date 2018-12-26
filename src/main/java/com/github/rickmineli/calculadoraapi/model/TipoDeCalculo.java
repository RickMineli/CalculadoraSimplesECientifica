package com.github.rickmineli.calculadoraapi.model;

import java.util.List;

public enum TipoDeCalculo {

    SIMPLES {
        @Override
        public Double executaEquacao(List<Object> equacaoEmLista) {
            Double primeroNumero = (Double) equacaoEmLista.get(0);
            Double segundoNumero;
            Operacao operacao;

            for (int i = 1; i < equacaoEmLista.size(); i = i + 2) {
                operacao = Operacao.valueOf((String) equacaoEmLista.get(i));
                segundoNumero = (Double) equacaoEmLista.get(i + 1);
                primeroNumero = operacao.executarOperacao(primeroNumero, segundoNumero);
            }
            return primeroNumero;
        }
    },
    CIENTIFICA {
        @Override
        public Double executaEquacao(List<Object> equacaoEmLista) {
            Double primeroNumero;
            Double segundoNumero;
            Operacao operacao;

            for (int i = 1; i < equacaoEmLista.size(); i = i + 2) {
                System.out.println("Entrou no for");
                if (Operacao.MULTIPLICACAO == Operacao.valueOf((String) equacaoEmLista.get(i))) {
                    System.out.println("Entrou no if multi");
                    equacaoEmLista = fazMultiEDiviCientifica(Operacao.MULTIPLICACAO, equacaoEmLista, i);
                }
                if (Operacao.DIVISAO == Operacao.valueOf((String) equacaoEmLista.get(i))) {
                    equacaoEmLista = fazMultiEDiviCientifica(Operacao.DIVISAO, equacaoEmLista, i);
                }
            }

            System.out.println(equacaoEmLista);
            return TipoDeCalculo.SIMPLES.executaEquacao(equacaoEmLista);
        }
    };

    public abstract Double executaEquacao(List<Object> equacaoEmLista);

    public List<Object> fazMultiEDiviCientifica(Operacao operacao, List<Object> equacaoEmLista, int i) {
        Double primeroNumero = (Double) equacaoEmLista.get(i - 1);
        Double segundoNumero = (Double) equacaoEmLista.get(i + 1);
        equacaoEmLista.set(i - 1, operacao.executarOperacao(primeroNumero, segundoNumero));
        equacaoEmLista.remove(i);
        equacaoEmLista.remove(i);
        return equacaoEmLista;
    }

}
