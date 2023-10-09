package Exercicio01;

public class Equipamento {

    private String modelo;
    private String fabricante;
    private double consumoDia;

    public Equipamento(String modelo, String fabricante, double capacidade) {
        super();
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.consumoDia = consumoDia;
    }

    public Equipamento() {
        super();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public double getConsumoDia() {
        return consumoDia;
    }

    public void setConsumoDia(double consumoDia) {
        this.consumoDia = consumoDia;
    }

    public double calcularConsumoMensal() {
        return consumoDia * 30;
    }
    public double calcularConsumoDiario(int dias){
        return consumoDia * dias;
    }
}
