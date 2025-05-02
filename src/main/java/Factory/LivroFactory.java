package Factory;

import Controllers.LivroController;
import entities.Livro;

public class LivroFactory {
    private LivroController livroController;

    public LivroFactory(LivroController livroController) {
        this.livroController = livroController;
    }

    public void CadastrarLivro(String titulo, String autor, String anoDePublicacao, String exemplaresDisponiveis, String categoria, int id) {

    }

}
