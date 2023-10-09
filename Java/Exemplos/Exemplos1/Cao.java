package Exemplos1;

public class Cao {
    //atributo
    private String nome;
    private double peso;
    private String raca;


    // get e set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso > 0){
            this.peso = peso;
        } else {
            System.out.println("Um cão não pode ter um peso negativo.");
        }

    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    //metodo
    public void falar() {
        if(peso > 60) {
            System.out.println("Woof, Woof, Woof");
        } else{
            if (peso <15) {
                System.out.println("Yip, Yip, Yip,");
            } else{
                System.out.println("Ruff, Ruff, Ruff");
            }
        }
    }
}
