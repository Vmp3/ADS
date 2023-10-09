package Exemplos2;

import org.w3c.dom.ls.LSOutput;

public class ProgramaVeiculo {

/*
    public static void main(String[] args) {
        String motoFabricanteAntiga = new String();
        String motoModeloAntiga = new String();
        String carroModeloMaior = new String();
        double maiorPot = 0;
        int[] teste = new int[4];

        Carro c1 = new Carro("Focus", "Ford", 2020, 45000.00, 170);
        Carro c2 = new Carro("Golf", "Volks", 2000, 15000.00, 120);
        Carro c3 = new Carro("Fusca", "Volks", 1980, 35000.00, 190);

        Moto m1 = new Moto("CG-150", "Honda", 2022, 8000.00, 300);
        Moto m2 = new Moto("Ninja-1000", "Kawasaki", 2011, 18000.00, 1000);
        Moto m3 = new Moto("Halley", "Halley", 1995, 50000.00, 1200);

        Carro[] listaCarro = {c1, c2, c3};
        Moto[] listaMoto = {m1, m2, m3};

        double valorTotalCarros = calcularValorTotalCarros(listaCarro);
        identificarMaiorPotencia(listaCarro);
        double valorTotalMotos = calcularValorTotalMotos(listaMoto);
        identificarMotoMaisAntiga(listaMoto);
    }

    private static double calcularValorTotalCarros(Carro[] listaCarro) {
        double acumulador = 0;
        for (int i = 0; i < listaCarro.length; i++) {
            acumulador += listaCarro[i].getValor();
        }
        return acumulador;
    }
    private static void identificarMaiorPotencia(Carro[] listaCarro){
        Carro carro = listaCarro[0];
        for (int i = 0; i < listaCarro.length; i++){
        if (listaCarro[i].getPotenciaCV() > carro.getPotenciaCV()){
            carro = listaCarro[i];
        }
        }
    }

*/




}

//1 - Calcular o valor total dos carros.
//2 - Informar o modelo do carro com maior potência.
//3 - Informar o valor total das motos.
//4 - Informar o modelo e o fabricante da moto mais antiga.
//5 - Contabilizar o valor de todos os veículos.

/*
        Carro[] listaCarros = {c1,c2,c3};
        Moto[] listaMotos = {m1,m2,m3};
        double totalCarro = c1.getValor()+c2.getValor()+c3.getValor();

        if(c1.getPotenciaCV() > c2.getPotenciaCV() && c1.getPotenciaCV() > c3.getPotenciaCV()){
            carroModeloMaior = c1.getModelo();
        } if(c2.getPotenciaCV() > c2.getPotenciaCV() && c2.getPotenciaCV() > c3.getPotenciaCV()){
            carroModeloMaior = c2.getModelo();
        } if(c3.getPotenciaCV() > c2.getPotenciaCV() && c3.getPotenciaCV() > c1.getPotenciaCV()){
            carroModeloMaior = c3.getModelo();
        }

        if(m1.getAno() < m2.getAno() && m1.getAno() < m3.getAno()){
            motoModeloAntiga = m1.getModelo();
            motoFabricanteAntiga = m1.getFabricante();
        }if(m2.getAno() < m1.getAno() && m2.getAno() < m3.getAno()) {
            motoModeloAntiga = m2.getModelo();
            motoFabricanteAntiga = m2.getFabricante();
        }if(m3.getAno() < m2.getAno() && m3.getAno() < m1.getAno()){
            motoModeloAntiga = m3.getModelo();
            motoFabricanteAntiga = m3.getFabricante();
        }
        System.out.println(motoFabricanteAntiga + motoModeloAntiga);
        double totalMoto = m1.getValor()+m2.getValor()+m3.getValor();

        double totalVeiculos = m1.getValor()+m2.getValor()+m3.getValor()+c1.getValor()+c2.getValor()+c3.getValor();

        System.out.println("Valor total dos carros: R$" + totalCarro);
        System.out.println("Carro com maior potência: " + carroModeloMaior);
        System.out.println("Valor total dos moto: R$" + totalMoto);
        System.out.println("Modelo e fabricante da moto mais antiga: " + motoModeloAntiga + ", " + motoFabricanteAntiga);
        System.out.println("Valor total dos veículos: R$" + totalVeiculos);
    }

 */