package simulado2;

import java.util.Scanner;

public class Escola {
    Scanner teclado = new Scanner(System.in);
    private String nome;
    private String telefone;
    private Endereco endereco;
    private Turma [] turma;

    public Escola(String nome, String telefone, Endereco endereco, Turma[] turma) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.turma = turma;
    }

    public Escola() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Turma[] getTurma() {
        return turma;
    }

    public void setTurma(Turma[] turma) {
        this.turma = turma;
    }

    public void contabilizarAlunas(){
        int contador = 0;

        for (Turma turma : this.getTurma()){
            contador += turma.getAluno().length;
        }
        System.out.println("A quantidade de alunos é: " + contador);
    }

    public void localizarEnderecoRegente(String nome){

        for (Turma turma : this.getTurma()){
            if (turma.getProfessor().getNome().equalsIgnoreCase(nome)){
                System.out.println(" \nO endereço do regente " + nome + " é: " + turma.getProfessor().getEndereco().getRua() + ", " + turma.getProfessor().getEndereco().getNumero() + ", " + turma.getProfessor().getEndereco().getBairro() + ", " + turma.getProfessor().getEndereco().getCidade() + ", " + turma.getProfessor().getEndereco().getEstado()) ;
            }
        }
    }

    public void listarNomeAlunas(int serie) {
        System.out.println(" \nAlunas presentes na série " + serie + ": ");

        for (Turma turma : this.getTurma()) {
            if (turma.getSerie() == serie) {
                turma.listarAlunas();
            }
        }
    }

    public void regenteMaisNovo() {
    int maisNovo = Integer.MAX_VALUE;
    String regMaisNovo = "";
        for (Turma turma : this.getTurma()){
        if(turma.getProfessor().getIdade() < maisNovo){
            maisNovo = turma.getProfessor().getIdade();
            regMaisNovo = turma.getProfessor().getNome();
            }
        }
        System.out.println( "\n" + regMaisNovo + " é o regente mais novo da escola  \n");
    }

    public void listarAlunasCidade(String cidade) {
        for (int i = 0; i < this.getTurma().length; i++){
            this.getTurma()[i].listarAlunasCidade(cidade);
        }
    }
}

