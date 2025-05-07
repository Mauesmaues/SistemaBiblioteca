package factory;

import controllers.LivroController;

public class LivroFactory {
    private LivroController livroController;

    public LivroFactory(LivroController livroController) {
        this.livroController = livroController;
    }

    public void CadastrarLivro(String titulo, String autor, String anoDePublicacao, String exemplaresDisponiveis, String categoria, int id) {

    }

}
