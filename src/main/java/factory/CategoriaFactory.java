package factory;

import controllers.CategoriaController;
import model.Categoria;

import java.util.Optional;

public final class CategoriaFactory {

    public static Categoria criarCategoria(String nomeCategoria, String descricaoCategoria) {

        return new Categoria(nomeCategoria, descricaoCategoria);
    }

}
