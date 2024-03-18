package exemplo.lista.exemplo.lista;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.exemplolista.model.Carro;

import service.TesteService;

@Controller
public class Teste {

    @Autowired
    private TesteService testeService;

    @GetMapping("/")
    public String exibeModelos(Model m) {

        List<Carro> carros = testeService.recheiaLista();

        String resultado = "";

        for (Carro carro : carros) {
            resultado += "Modelo: " + carro.getModelo() + ", ano: " + carro.getAno() + "\n";
        }

        m.addAttribute("mensagem", resultado);

        return "tela";
    }

}
