package Exemplos2;

public class Veiculo {

    private String modelo;
    private String fabricante;
    private int ano;
    private double valor;

    public Veiculo(String modelo, String fabricante, int ano, double valor) {
        super();
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.ano = ano;
        this.valor = valor;
    }

    public Veiculo() {
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

