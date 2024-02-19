package Exercicio01;

public class Geladeira extends Equipamento{

    private double capacidadeLitros;

    public Geladeira(String modelo, String fabricante, double capacidadeLitros) {
        super(modelo, fabricante, capacidadeLitros);
    }

    public Geladeira() {
        super();
    }
}
