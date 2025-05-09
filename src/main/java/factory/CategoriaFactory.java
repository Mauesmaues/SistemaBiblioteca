package factory;

import controllers.CategoriaController;
import entities.Categoria;

import java.util.List;
import java.util.Optional;

public final class CategoriaFactory {
    private static final CategoriaController categoriaController = new CategoriaController();;

    public static Optional<Categoria> criarCategoria(String nomeCategoria, String descricaoCategoria) {

        if(nomeCategoria.isEmpty() || descricaoCategoria.isEmpty()){return Optional.empty();}

        Categoria categoria = new Categoria(nomeCategoria, descricaoCategoria);
        return Optional.of(categoria);
    }

}
