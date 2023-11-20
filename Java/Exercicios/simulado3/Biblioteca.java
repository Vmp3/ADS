package simulado3;

public class Biblioteca {
    private String nome;
    private Endereco endereco;
    private Obra [] obra;

    public Biblioteca(String nome, Endereco endereco, Obra[] obra) {
        this.nome = nome;
        this.endereco = endereco;
        this.obra = obra;
    }

    public Biblioteca() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Obra[] getObra() {
        return obra;
    }

    public void setObra(Obra[] obra) {
        this.obra = obra;
    }
}
