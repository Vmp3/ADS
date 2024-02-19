package simulado3;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Biblioteca {

    private String nome;
    private Endereco enderecoBiblioteca;
    private Obra[] listaObras;

    public Biblioteca(String nome, Endereco enderecoBiblioteca, Obra[] listaObras) {
        super();
        this.nome = nome;
        this.enderecoBiblioteca = enderecoBiblioteca;
        this.listaObras = listaObras;
    }

    public Biblioteca() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEnderecoBiblioteca() {
        return enderecoBiblioteca;
    }

    public void setEnderecoBiblioteca(Endereco enderecoBiblioteca) {
        this.enderecoBiblioteca = enderecoBiblioteca;
    }

    public Obra[] getListaObras() {
        return listaObras;
    }

    public void setListaObras(Obra[] listaObras) {
        this.listaObras = listaObras;
    }

    public void contabilizarObras() {
        System.out.println("A quantidade de obras é: " + getListaObras().length);
    }


    public void obraMaisAntiga() {

        Obra obraMaisAntiga = listaObras[0];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Obra obra : this.getListaObras()) {

            LocalDate dataObra = obra.getDataPublicacao();

            if (dataObra.isBefore(obraMaisAntiga.getDataPublicacao())) {
                obraMaisAntiga = obra;
            }
        }
        System.out.println("As informações da obra mais antiga são: \n Titulo: " + obraMaisAntiga.getTitulo() +
                "\n Data de publicação: " + obraMaisAntiga.getDataPublicacao().format(formatter) +
                "\n Edição: " + obraMaisAntiga.getEdicao());
    }


    public void autorMaisNovo() {
        Autor autorMaisNovo = listaObras[0].getAutor();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Obra obra : this.getListaObras()) {

            Autor autorObra = obra.getAutor();

            if (autorObra.getDataNascimento().isAfter(autorMaisNovo.getDataNascimento())) {
                autorMaisNovo = autorObra;
            }
        }
        System.out.println("As informações do autor mais novo são: " +
                "\n A data de nascimento do autor mais novo é: " + autorMaisNovo.getDataNascimento().format(formatter) +
                "\n O nome do autor mais novo é: " + autorMaisNovo.getNome() +
                "\n O endereço do autor mais novo é: " + autorMaisNovo.getEnderecoAutor());
    }

    public void calcularDiferencaNascimento() {

        Autor autorMaisVelho = listaObras[0].getAutor();
        Autor autorMaisNovo = listaObras[0].getAutor();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Obra obra : this.getListaObras()) {

            Autor autorObra = obra.getAutor();

            if (autorObra.getDataNascimento().isBefore(autorMaisVelho.getDataNascimento())) {
                autorMaisVelho = autorObra;
            }

            if (autorObra.getDataNascimento().isAfter(autorMaisNovo.getDataNascimento())) {
                autorMaisNovo = autorObra;
            }
        }
        Period comparar = Period.between(autorMaisVelho.getDataNascimento(), autorMaisNovo.getDataNascimento());

        System.out.println("Informações sobre a diferença de idades: " +
                "\n Nome do autor mais novo: " + autorMaisNovo.getNome() +
                "\n Nome do autor mais velho: " + autorMaisVelho.getNome() +
                "\n Diferença em anos: " + comparar.getYears() +
                "\n Diferença em meses: " + comparar.getMonths() +
                "\n Diferença em dias: " + comparar.getDays());
    }

    public void localizarAutor(String nome) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean autorEncontrado = false;

        for (Obra obra : listaObras) {
            Autor autor = obra.getAutor();

            if (autor.getNome().equals(nome)) {
                autorEncontrado = true;
                System.out.println("Informações sobre o autor " + nome + ":");
                System.out.println("Nome: " + autor.getNome());
                System.out.println("Data de Nascimento: " + autor.getDataNascimento().format(formatter));
                System.out.println("Endereço: " + autor.getEnderecoAutor());
                break;
            }
        }

        if (!autorEncontrado) {
            System.out.println("O autor " + nome + " não foi encontrado!");
        }
    }

    public void localizarAutorCidade(String cidade) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean cidadeEncontrada = false;

        System.out.println("Moradores da cidade " + cidade + ":");

        // Usar um conjunto para rastrear os autores já impressos
        Set<Autor> autoresImprimidos = new HashSet<>();

        for (Obra obra : listaObras) {
            Autor autor = obra.getAutor();

            // Verificar se o autor ainda não foi impresso para a cidade atual
            if (autor.getEnderecoAutor().getCidade().equals(cidade) && !autoresImprimidos.contains(autor)) {
                autoresImprimidos.add(autor);  // Adicionar o autor ao conjunto de autores impressos
                cidadeEncontrada = true;

                System.out.println("Nome: " + autor.getNome());
                System.out.println("Data de Nascimento: " + autor.getDataNascimento().format(formatter));
                System.out.println("Endereço: " + autor.getEnderecoAutor());
                System.out.println();
            }
        }

        if (!cidadeEncontrada) {
            System.out.println("Nenhum morador encontrado na cidade " + cidade + "!");
        }
    }
}