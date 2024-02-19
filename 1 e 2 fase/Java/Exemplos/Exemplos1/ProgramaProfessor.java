package Exemplos1;

import java.util.Scanner;

public class ProgramaProfessor {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Professor professor1 = new Professor();
        System.out.println("Informe o nome do professor: ");
        professor1.setNome(teclado.nextLine());
        System.out.println("Informe o salário do professor: ");
        professor1.setSalario(teclado.nextInt());
        teclado.nextLine();

        Professor professor2 = new Professor();
        System.out.println("Informe o nome do professor: ");
        professor2.setNome(teclado.nextLine());
        System.out.println("Informe o salário do professor: ");
        professor2.setSalario(teclado.nextInt());
        teclado.nextLine();

        if (professor1.getSalario() > professor2.getSalario()) {
            System.out.println("O professor " + professor1.getNome() + " possui o salário maior.");
        } else {
            System.out.println("O professor " + professor2.getNome() + " possui o salário maior.");
        }


        teclado.close();

    }
}