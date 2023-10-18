import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VeiculoSubaquatico veiculo = new VeiculoSubaquatico(480);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Entrar Passageiro");
            System.out.println("2. Desembarcar Passageiros");
            System.out.println("3. Listar Passageiros e Peso Atual");
            System.out.println("4. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    try {
                        System.out.print("Nome do Passageiro: ");
                        String nome = scanner.next();
                        System.out.print("Peso do Passageiro (em kg): ");
                        double peso = scanner.nextDouble();
                        veiculo.entrarPassageiro(nome, peso);
                    } catch (InputMismatchException e) {
                        System.out.println("Valor inválido. Certifique-se de inserir um número válido para o peso.");
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    veiculo.desembarcarPassageiros();
                    break;
                case 3:
                    veiculo.listarPassageiros();
                    break;
                case 4:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }
}
