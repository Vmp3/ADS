package Exemplos1;

public class Professor extends Pessoa{

    private double salario;

    public Professor(String nome, int matricula, Contato contato, double salario) {
        super(nome, matricula, contato);
        this.salario = salario;
    }

    public Professor() {
        super();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void informarDadosContato() {
        System.out.println("Nome: " + this.getNome() + " - Telefone: " + this.getContato().getTelefone());
    }
}
