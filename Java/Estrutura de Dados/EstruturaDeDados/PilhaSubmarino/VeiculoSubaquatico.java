import java.util.Stack;

public class VeiculoSubaquatico {
    private Stack<Passageiro> assentos;
    private double capacidadeMaxima;

    public VeiculoSubaquatico(int capacidadeMaxima) {
        assentos = new Stack<>();
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public boolean entrarPassageiro(String nome, double peso) {
        if (getPesoAtual() + peso <= capacidadeMaxima) {
            Passageiro passageiro = new Passageiro(nome, peso);
            assentos.push(passageiro);
            return true;
        } else {
            System.out.println("O veículo está lotado. Não é possível entrar.");
            return false;
        }
    }

    public void desembarcarPassageiros() {
        System.out.println("Passageiros a desembarcar na ordem de saída:");
        while (!assentos.isEmpty()) {
            Passageiro passageiro = assentos.pop();
            System.out.println(passageiro.getNome());
        }
    }

    public double getPesoAtual() {
        double pesoAtual = 0;
        for (Passageiro passageiro : assentos) {
            pesoAtual += passageiro.getPeso();
        }
        return pesoAtual;
    }

    public void listarPassageiros() {
        System.out.println("Lista de passageiros:");
        for (Passageiro passageiro : assentos) {
            System.out.println(passageiro.getNome() + " - Peso: " + passageiro.getPeso() + " kg");
        }
        System.out.println("Peso total atual: " + getPesoAtual() + " kg");
    }
}
