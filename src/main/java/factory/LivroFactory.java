package factory;

import model.Autor;
import model.Categoria;
import model.Livro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public final class LivroFactory {

    public static Livro criarLivro(String titulo, Autor autor, LocalDate anoDePublicacao, int exemplaresDisponiveis, Categoria categoria, int id) {

        return new Livro(titulo, autor, anoDePublicacao, exemplaresDisponiveis, id, categoria);
    }
}
