package com.carros.controller;

import com.carros.util.ValidaPlaca;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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
                               @RequestParam("placa") String placa, Model m) {

        String resultado = "Ops, a placa não é válida!";

        if (ValidaPlaca.validaPlaca(placa)) {
            Carro carro = new Carro(nome, fabricante, placa, null);
            carroRepository.save(carro);
            resultado = "Carro modelo: " + carro.getNome() + " cadastrado com sucesso! " + "A placa do veículo é: " + carro.getPlaca();
        }
        m.addAttribute("carro", resultado); // Note: Changed attribute name to 'resultado' for clarity
        return "sucesso_carro";
    };
    public ListCarroAll(Model m){
        
    }
}