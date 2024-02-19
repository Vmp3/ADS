package simulado3;

import java.time.LocalDate;

public class Livro extends Obra{
    public Livro(String titulo, int edicao, LocalDate dataPublicacao, Autor autor) {
        super(titulo, edicao, dataPublicacao, autor);
    }

    public Livro() {
        super();
    }
}
