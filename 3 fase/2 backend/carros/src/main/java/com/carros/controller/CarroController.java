package com.carros.controller;

import com.carros.util.ValidaPlaca;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.carros.model.Carro;
import com.carros.repository.CarroRepository;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CarroController {
    private final CarroRepository carroRepository;

    public CarroController(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @PostMapping("/entrada")
    public String EntradaCarro(@RequestParam("nome") String nome,
                               @RequestParam("fabricante") String fabricante,
                               @RequestParam("placa") String placa, Model m) {


        String resultado = "Ops, a placa não é válida!";
        m.addAttribute("carro", resultado); 
        
        if (ValidaPlaca.validaPlaca(placa)) {
            Carro carro = new Carro(nome, fabricante, placa, null, null);
            carroRepository.save(carro);
            resultado = "Carro modelo: " + carro.getNome() + " cadastrado com sucesso! " + "A placa do veículo é: " + carro.getPlaca();
            return"redirect:/carro";
        } else{
            return "sucesso_carro";
        }
 
  
    };

    @GetMapping("/carro")
    public String ListCarroAll(Model m){
        List<Carro> carros = carroRepository.findAll();
        m.addAttribute("carros",carros);
        return "lista-carros";

    }
}