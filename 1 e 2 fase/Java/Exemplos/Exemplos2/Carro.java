package Exemplos2;

public class Carro extends Veiculo{

    private double potenciaCV;

    public Carro(String modelo, String fabricante, int ano, double valor, double potenciaCV) {
        super(modelo, fabricante, ano, valor);
        this.potenciaCV = potenciaCV;
    }
    public Carro(){
        super();
    }

    public double getPotenciaCV() {
        return potenciaCV;
    }

    public void setPotenciaCV(double potenciaCV) {
        this.potenciaCV = potenciaCV;
    }
}
