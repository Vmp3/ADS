package simulado1;

public class Farmacia {

    private String nome;
    private Endereco endereco;
    private String cpnj;

    public Farmacia(String nome,Endereco endereco, String cpnj) {
        super();
        this.nome = nome;
        this.endereco = endereco;
        this.cpnj = cpnj;
    }

    public Farmacia() {
        super();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString(){
        return "Nome: " + this.getNome();
    }
}
