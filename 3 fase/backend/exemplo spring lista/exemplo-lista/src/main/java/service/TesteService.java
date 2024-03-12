package service;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exemplolista.model.Carro;

@Service
public class TesteService {
    Carro c1 = new Carro("Astra", 2001);
    Carro c2 = new Carro("Marea ELX", 2003);
    Carro c3 = new Carro("Evoque", 2023);
    Carro c4 = new Carro("C4 Pallas", 2008);

    List<Carro> carros = new ArrayList<>();

    public List<Carro> recheiaLista() {
        carros.add(c1);
        carros.add(c2);
        carros.add(c3);
        carros.add(c4);

        return carros;
    }
}


