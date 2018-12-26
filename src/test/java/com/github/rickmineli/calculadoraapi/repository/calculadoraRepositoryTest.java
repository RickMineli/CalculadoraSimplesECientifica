package com.github.rickmineli.calculadoraapi.repository;


import com.github.rickmineli.calculadoraapi.exception.JSONInvalidoException;
import com.github.rickmineli.calculadoraapi.model.Calculo;
import com.github.rickmineli.calculadoraapi.model.TipoDeCalculo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class calculadoraRepositoryTest {

    @Autowired
    private CalculoRepository calculoRepository;

    @After
    public void after() {
        calculoRepository.deleteAll();
    }

    @Test
    public void deveSalvarUmNovoCalculoSimples() {
        List<Object> equacao = new ArrayList<>();
        equacao.add(5.0);
        equacao.add("SOMA");
        equacao.add(7.0);
        equacao.add("MULTIPLICACAO");
        equacao.add(4.0);
        equacao.add("SUBTRACAO");
        equacao.add(10.0);
        equacao.add("DIVISAO");
        equacao.add(2.0);
        Calculo novoCalculo = new Calculo(equacao, TipoDeCalculo.SIMPLES);
        calculoRepository.save(novoCalculo);
        List<Calculo> calculos = calculoRepository.findAll();
        Assert.assertEquals(novoCalculo.getResultado(), calculos.get(0).getResultado());
    }

    @Test
    public void deveSalvarUmNovoCalculoCientifico() {
        List<Object> equacao = new ArrayList<>();
        equacao.add(5.0);
        equacao.add("SOMA");
        equacao.add(7.0);
        equacao.add("MULTIPLICACAO");
        equacao.add(4.0);
        equacao.add("SUBTRACAO");
        equacao.add(10.0);
        equacao.add("DIVISAO");
        equacao.add(2.0);    Calculo novoCalculo = new Calculo(equacao, TipoDeCalculo.CIENTIFICA);
        calculoRepository.save(novoCalculo);
        List<Calculo> calculos = calculoRepository.findAll();
        Assert.assertEquals(novoCalculo.getResultado(), calculos.get(0).getResultado());
    }

    @Test(expected = JSONInvalidoException.class)
    public void naoDeveSalvarUmCalculoComEquacaoVazia() {
        List<Object> equacao = new ArrayList<>();
        Calculo novoCalculo = new Calculo(equacao, TipoDeCalculo.SIMPLES);
        calculoRepository.save(novoCalculo);
    }

    @Test(expected = JSONInvalidoException.class)
    public void naoDeveSalvarUmCalculoComValoresNegativos() {
        List<Object> equacao = new ArrayList<>();
        equacao.add(-2.0);
        equacao.add("SUBTRACAO");
        equacao.add(-2.0);
        Calculo novoCalculo = new Calculo(equacao, TipoDeCalculo.SIMPLES);
        calculoRepository.save(novoCalculo);
    }

    @Test(expected = JSONInvalidoException.class)
    public void naoDeveSalvarUmCalculoComDivisaoPorZero() {
        List<Object> equacao = new ArrayList<>();
        equacao.add(2.0);
        equacao.add("DIVISAO");
        equacao.add(0.0);
        Calculo novoCalculo = new Calculo(equacao, TipoDeCalculo.SIMPLES);
        calculoRepository.save(novoCalculo);
    }


}
