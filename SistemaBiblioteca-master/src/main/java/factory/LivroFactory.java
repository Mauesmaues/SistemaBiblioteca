package factory;

import model.Autor;
import model.Categoria;
import model.Livro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public final class LivroFactory {

    public static Optional<Livro> criarLivro(String titulo, Autor autor, String anoDePublicacao, int exemplaresDisponiveis, Categoria categoria, int id) {

        if(titulo.isEmpty() || anoDePublicacao.isEmpty() || exemplaresDisponiveis <= 0 || id < 0) {return Optional.empty();}

        LocalDate dataPublicacao = LocalDate.parse(anoDePublicacao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Livro livro = new Livro(titulo, autor, dataPublicacao, exemplaresDisponiveis, id, categoria);

        return Optional.of(livro);
    }
}
