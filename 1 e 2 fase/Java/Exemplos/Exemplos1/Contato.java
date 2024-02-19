package Exemplos1;

public class Contato {
    private int telefone;
    private String email;

    public Contato(int telefone, String email) {
        super();
        this.telefone = telefone;
        this.email = email;
    }

    public Contato() {
        super();

    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
