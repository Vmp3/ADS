package Exemplos2;

public class Moto extends Veiculo{

    private double cilindrada;

    public Moto(String modelo, String fabricante, int ano, double valor, double cilindrada) {
        super(modelo, fabricante, ano, valor);
        this.cilindrada = cilindrada;
    }

    public Moto() {
        super();
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }
}
