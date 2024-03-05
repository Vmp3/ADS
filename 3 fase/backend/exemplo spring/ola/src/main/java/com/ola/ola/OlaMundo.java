package com.ola.ola;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller


public class OlaMundo {
    @GetMapping("/")
    public String ola(Model m){
        m.addAttribute("mensagem","ola mundo");
        return "ola";
    }
    @GetMapping("oi")
    public String oi(@RequestParam(name = "user") String user, @RequestParam(name = "sexo") String sexo, Model m){
        String result = "Sexo não encontrado";
        if(sexo.equalsIgnoreCase("masculino") || sexo.equalsIgnoreCase("feminino")) {
            result = "oi, " + user + " seu sexo é " + sexo;
        }
        m.addAttribute("mensagem", result);
        return "ola";
    }
}
