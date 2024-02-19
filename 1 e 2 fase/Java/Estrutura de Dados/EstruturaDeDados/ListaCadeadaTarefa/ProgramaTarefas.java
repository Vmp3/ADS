package EstruturaDeDados.ListaCadeadaTarefa;

import java.util.Scanner;

public class ProgramaTarefas {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Tarefa primeiro = null;
        Tarefa ultimo = null;
        int opMenu_1 = 1;
        ASCIIArt.printMenu();

        while (opMenu_1 == 1) {
            int sw;
            System.out.println("Escolha a opção que deseja: ");
            System.out.println("1 - EXIBIR LISTA DE TAREFAS");
            System.out.println("2 - ADICIONAR TAREFA À LISTA");
            System.out.println("3 - REMOVER PRIMEIRA TAREFA DA LISTA");
            sw = input.nextInt();

            switch (sw) {
                case 1:
                    Tarefa proximaTarefa = primeiro;
                    while (proximaTarefa != null) {
                        System.out.println("Código: " + proximaTarefa.getCodigo() + ", Descrição: " + proximaTarefa.getDescricao());
                        proximaTarefa = proximaTarefa.getProximo();
                    }
                    break;
                case 2:
                    int opMenu_2 = 1;
                    while (opMenu_2 == 1) {
                        System.out.println("Nova tarefa....");
                        input.nextLine();
                        Tarefa tarefa = new Tarefa();
                        System.out.println("Informe a descrição da tarefa: ");
                        String descricao = input.nextLine();
                        tarefa.setDescricao(descricao);

                        System.out.println("Informe o código da tarefa: ");
                        int codigo = input.nextInt();
                        tarefa.setCodigo(codigo);

                        if (primeiro == null) {
                            primeiro = tarefa;
                        }
                        if (ultimo == null) {
                            ultimo = tarefa;
                        } else {
                            ultimo.setProximo(tarefa);
                            ultimo = tarefa;
                        }
                        input.nextLine();
                        System.out.println("Informe se gostaria de inserir mais uma tarefa: Sim=1|Não=0");
                        opMenu_2 = input.nextInt();
                    }
                    break;
                case 3:
                    if (primeiro != null) {
                        primeiro = primeiro.getProximo();
                    } else {
                        System.out.println("A lista de tarefas está vazia.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            input.nextLine();
            System.out.println("Informe se gostaria de voltar ao menu principal? Sim=1|Não=0");
            opMenu_1 = input.nextInt();
        }

        input.close();
        System.out.println("Final do programa....");
    }
}
