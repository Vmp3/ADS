package simulado2;

public class Professor extends Pessoa{

    private String Disciplina;

    public Professor(String nome, int idade, Endereco endereco, String disciplina) {
        super(nome, idade, endereco);
        Disciplina = disciplina;
    }

    public Professor() {
        super();
    }

    public String getDisciplina() {
        return Disciplina;
    }

    public void setDisciplina(String disciplina) {
        Disciplina = disciplina;
    }
}
