package com.carros.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.carros.model.Carro;
import com.carros.repository.CarroRepository;

@Controller
public class CarroController {
    private final CarroRepository carroRepository;

    public CarroController(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @PostMapping("/entrada")
    public String EntradaCarro(@RequestParam("nome") String nome,
            @RequestParam("fabricante") String fabricante,
            @RequestParam("placa") String placa) {
        Carro carro = new Carro(nome, fabricante, placa, null);
        carroRepository.save(null);
        return "";

    };
}
