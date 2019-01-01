package com.github.rickmineli.calculadoraapi.controller;

import com.github.rickmineli.calculadoraapi.dto.CalculoDTO;
import com.github.rickmineli.calculadoraapi.model.Calculo;
import com.github.rickmineli.calculadoraapi.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("api/calculos")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;

    @PostMapping
    public Calculo postCalculo(@RequestBody CalculoDTO calculo){
        return calculoService.salvaNovoCalculo(calculo.getEquacaoEmLista(),calculo.getTipoDeCalculo());
    }
    @GetMapping
    public List<Calculo> todasCalculadoras(){
        return calculoService.buscarTodosOsCalculos();
    }
}
