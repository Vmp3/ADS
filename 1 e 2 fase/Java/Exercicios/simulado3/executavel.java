package simulado3;
import java.time.LocalDate;
import java.util.Scanner;
public class executavel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Endereco enderecoDrummond = new Endereco("Rua das maças", 100, "Ingleses", "Florianópolis", "Santa Catarina");
        Autor drummond = new Autor("Carlos Drummond", LocalDate.of(1946, 10, 1), enderecoDrummond);

        Endereco enderecoAssis = new Endereco("Rua das laranjas", 200, "Aririu", "Palhoça", "Santa Catarina");
        Autor assis = new Autor("Machado de Assis", LocalDate.of(1915, 3, 15), enderecoAssis);

        Endereco enderecoMeirelles = new Endereco("Rua das uvas", 300, "Pedra Branca", "Palhoça", "Santa Catarina");
        Autor meirelles = new Autor("Cecilia Meirelles", LocalDate.of(1927, 5, 21), enderecoMeirelles);

        Endereco enderecoAndrade = new Endereco("Rua das melancias", 400, "Estreito", "Florianópolis", "Santa Catarina");
        Autor andrade = new Autor("Osvald de Andrade", LocalDate.of(1934, 6, 4), enderecoAndrade);

        Revista veja = new Revista("Revista Veja", 60, LocalDate.of(2012, 12, 1), drummond);
        Livro brejo = new Livro("Brejo das Almas", 8, LocalDate.of(1983, 1, 30), drummond);

        Revista istoe = new Revista("IstoÉ", 80, LocalDate.of(2013, 6, 1), assis);
        Livro quincas = new Livro("Quincas Borba", 1, LocalDate.of(1892, 5, 13), assis);

        Revista autoEsporte = new Revista("Auto Esporte", 20, LocalDate.of(2011, 9, 1), meirelles);
        Livro colarDeCarolina = new Livro("Colar de Carolina", 3, LocalDate.of(1934, 11, 20), meirelles);

        Revista superInteressante = new Revista("Super Interessante", 100, LocalDate.of(2010, 4, 1), andrade);
        Livro osCondenados = new Livro("Os Condenados", 7, LocalDate.of(1941, 7, 28), andrade);

        Obra [] listaObras = {veja, brejo, istoe, quincas, autoEsporte, colarDeCarolina, superInteressante, osCondenados};

        Endereco bibliotecaCentral = new Endereco("Rua das mangas", 600, "Centro", "Florianópolis", "Santa Catarina");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", bibliotecaCentral, listaObras);

        // 1
        biblioteca.contabilizarObras();
        System.out.println();

        // 2
        biblioteca.obraMaisAntiga();
        System.out.println();

        // 3
        biblioteca.autorMaisNovo();
        System.out.println();

        // 4
        biblioteca.calcularDiferencaNascimento();
        System.out.println();

        // 5
        String nome;

        System.out.println("Informe um autor para obter suas informações: ");
        nome = scan.nextLine();
        biblioteca.localizarAutor(nome);
        System.out.println();

        // 6
        String cidade;
        System.out.println("Informe o nome de uma cidade: ");
        cidade = scan.nextLine();
        biblioteca.localizarAutorCidade(cidade);
    }
}
