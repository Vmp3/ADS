package EstruturaDeDados.ListaCadeadaTarefa;

public class Tarefa {
    private String descricao;
    private int codigo;
    private Tarefa proximo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Tarefa getProximo() {
        return proximo;
    }

    public void setProximo(Tarefa proximo) {
        this.proximo = proximo;
    }
}
