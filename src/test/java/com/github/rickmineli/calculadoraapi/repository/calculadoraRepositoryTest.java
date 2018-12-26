package com.github.rickmineli.calculadoraapi.repository;


import com.github.rickmineli.calculadoraapi.exception.ListaEquacaoVaziaException;
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
    public void deveSalvarUmNovoCalculo(){
        List<Object> equacao = new ArrayList<>();
        equacao.add(12.0);
        equacao.add("SOMA");
        equacao.add(2.0);
        Calculo novoCalculo =  new Calculo(equacao, TipoDeCalculo.SIMPLES);
        calculoRepository.save(novoCalculo);
        List<Calculo> calculos = calculoRepository.findAll();
        Assert.assertEquals(novoCalculo.getResultado(), calculos.get(0).getResultado());
    }

    @Test(expected = ListaEquacaoVaziaException.class)
    public void naodeveSalvarUmCalculoComEquacaoVazia(){
        List<Object> equacao = new ArrayList<>();
        Calculo novoCalculo =  new Calculo(equacao, TipoDeCalculo.SIMPLES);
        calculoRepository.save(novoCalculo);
        List<Calculo> calculos = calculoRepository.findAll();
    }

}
