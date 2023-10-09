package simulado1;

public class Estoque {

    private int Qntd;
    private Remedio remedio;
    private Farmacia farmacia;
    private String responsavel;

    public Estoque(int qntd, Remedio remedio, Farmacia farmacia, String responsavel) {
        super();
        Qntd = qntd;
        this.remedio = remedio;
        this.farmacia = farmacia;
        this.responsavel = responsavel;
    }

    public Estoque() {
        super();
    }

    public int getQntd() {
        return Qntd;
    }

    public void setQntd(int qntd) {
        Qntd = qntd;
    }

    public Remedio getRemedio() {
        return remedio;
    }

    public void setRemedio(Remedio remedio) {
        this.remedio = remedio;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}

