package simulado2;

public class Turma {

    private int serie;
    private Aluno [] aluno;
    private Professor professor;


    public Turma(int serie, Aluno[] aluno, Professor professor) {
        this.serie = serie;
        this.aluno = aluno;
        this.professor = professor;
    }

    public Turma() {
        super();
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public Aluno[] getAluno() {
        return aluno;
    }

    public void setAluno(Aluno[] aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void listarAlunas() {
        for (Aluno aluno : this.getAluno()){
            System.out.println(aluno.getNome());
        }
    }

    public void listarAlunasCidade(String cidade) {
        for (int i = 0; i < this.getAluno().length; i++){
            if (this.getAluno()[i].getEndereco().getCidade().equalsIgnoreCase(cidade)){
                System.out.println(this.getAluno()[i].getNome());
            }
        }
    }
}
