package Exemplos1;

public class Pessoa {

    private String nome;
    private int matricula;
    private Contato contato;

    public Pessoa(String nome, int matricula, Contato contato) {
        super();
        this.nome = nome;
        this.matricula = matricula;
        this.contato = contato;
    }

    public Pessoa() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
}
