package simulado1;

import java.util.Scanner;

public class ProgramaFarmacia {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Endereco e1 = new Endereco("Rua dos Remédios", 100, "Centro", "Palhoça", "Santa Catarina");
        Endereco e2 = new Endereco("Rua da Medicação", 200, "Estreito", "Florianópolis", "Santa Catarina");
        Endereco e3 = new Endereco("Rua Jardim Silva", 360, "Centro", "Florianópolis", "Santa Catarina");

        Laboratorio l1 = new Laboratorio("LeGrand", "12.345.678/0001-11", e1);
        Laboratorio l2 = new Laboratorio("Medley", "12.345.678/0001-22", e2);


        Remedio r1 = new Remedio(55.00, "Rosuvas", l1);
        Remedio r2 = new Remedio(35.00, "Glifage", l1);
        Remedio r3 = new Remedio(50.00, "Aradois H", l1);
        Remedio r4 = new Remedio(10.00, "Trandilax", l1);
        Remedio r5 = new Remedio(50.00, "Rosuvastatina", l2);
        Remedio r6 = new Remedio(40.00, "Lexotan", l2);
        Remedio r7 = new Remedio(45.00, "Losartana", l2);
        Remedio r8 = new Remedio(15.00, "Torsilax", l2);

        Farmacia f1 = new Farmacia("Farmácia do Senac", e3, "12.345.678/0001-33");

        Estoque es1 = new Estoque(4, r1, f1, "Luciano");
        Estoque es2 = new Estoque(3, r2, f1, "Luciano");
        Estoque es3 = new Estoque(2, r3, f1, "Luciano");
        Estoque es4 = new Estoque(1, r4, f1, "Luciano");
        Estoque es5 = new Estoque(1, r5, f1, "Luciano");
        Estoque es6 = new Estoque(2, r6, f1, "Luciano");
        Estoque es7 = new Estoque(3, r7, f1, "Luciano");
        Estoque es8 = new Estoque(4, r8, f1, "Luciano");

        System.out.println("Responsavel: " + es1.getResponsavel());

        double somaTotal = 0;

        Estoque[] listaEstoque = {es1, es2, es3, es4, es5, es6, es7, es8};

        for (Estoque estoque : listaEstoque) {
            somaTotal += estoque.getRemedio().getPreco() * estoque.getQntd();
        }
        System.out.println("Valor total do estoque: R$" + somaTotal);
        Estoque[] listaEstoque1 = {es1, es2, es3, es4};
        Estoque[] listaEstoque2 = {es5, es6, es7, es8};
        double somaEstoque = 0;
        int contador = 0;
        do {
            System.out.println("Informe o nome do laboratório que você deseja calcular o valor total do estoque:");
            String pergunta = teclado.nextLine();
            switch (pergunta.toLowerCase()) {
                case "legrand":
                    for (Estoque estoque : listaEstoque1) {
                        somaEstoque += estoque.getRemedio().getPreco() * estoque.getQntd();
                    }
                    contador++;
                    System.out.println("Valor total do estoque: R$" + somaEstoque);
                    break;

                case "medley":
                    for (Estoque estoque : listaEstoque2) {
                        somaEstoque += estoque.getRemedio().getPreco() * estoque.getQntd();
                    }
                    contador++;
                    System.out.println("Valor total do estoque: R$" + somaEstoque);
                    break;

                default:
                    System.out.println("Opção inválida! Digite um nome válido");
                    break;

            }
        } while (contador == 0);
int contador2 = 0;
        do {
            System.out.println("Informe o nome do laboratório que você deseja buscar as informações:");
            String pergunta = teclado.nextLine();
            switch (pergunta.toLowerCase()) {
                case "legrand":
                    System.out.println("O laboratório " + l1.getNome() + " possui o CNPJ " + l1.getCpnj() + " e está localizado no endereço " + l1.getEndereco());
                    contador2++;
                    break;

                case "medley":
                    System.out.println("O laboratório " + l2.getNome() + " possui o CNPJ " + l2.getCpnj() + " e está localizado no endereço " + l2.getEndereco());
                    contador2++;
                    break;

                default:
                    System.out.println("Opção inválida! Digite um nome válido");
                    break;
            }
        } while (contador2 == 0);

    }
}
