package simulado1;

public class Remedio {

    private Double preco;
    private String nome;
    private Laboratorio laboratorio;
    public Remedio(Double preco, String nome, Laboratorio laboratorio) {
        super();
        this.preco = preco;
        this.nome = nome;
        this.laboratorio = laboratorio;
    }

    public Remedio() {
        super();
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
    @Override
    public String toString(){
        return "O remédio " + this.getNome() + " custa R$" + this.getPreco();
    }
}
