package factory;

import controllers.CategoriaController;
import model.Categoria;

import java.util.Optional;

public final class CategoriaFactory {

    public static Optional<Categoria> criarCategoria(String nomeCategoria, String descricaoCategoria) {

        if(nomeCategoria.isEmpty() || descricaoCategoria.isEmpty()){return Optional.empty();}

        Categoria categoria = new Categoria(nomeCategoria, descricaoCategoria);
        return Optional.of(categoria);
    }

}
