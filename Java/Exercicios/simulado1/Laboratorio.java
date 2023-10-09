package simulado1;

public class Laboratorio {

    private String nome;
    private String cpnj;
    private Endereco endereco;

    public Laboratorio(String nome,String cpnj, Endereco endereco) {
        super();
        this.nome = nome;
        this.cpnj = cpnj;
        this.endereco = endereco;
    }

    public Laboratorio() {
        super();
    }

    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
