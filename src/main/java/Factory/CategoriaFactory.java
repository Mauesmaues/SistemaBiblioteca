package Factory;

import Controllers.CategoriaController;
import entities.Categoria;

import java.util.List;
import java.util.Optional;

public class CategoriaFactory {
    private CategoriaController categoriaController;

    public CategoriaFactory() {
        this.categoriaController = new CategoriaController();
    }

    public void criarCategoria(int idCategoria, String nomeCategoria, String descricaoCategoria) {
        Optional<Categoria> categoria =  this.categoriaController.buscarCategoriaPorNome(nomeCategoria);
        if(categoria.isPresent()) {
            System.out.println("Categoria ja existe");
        }else{
            Categoria categoriaClass = new Categoria(idCategoria, nomeCategoria, descricaoCategoria);
            this.categoriaController.cadastrarCategoria(categoriaClass);
        }
    }

    public void excluirCategoria(String nomeCategoria) {
        Optional<Categoria> categoria = this.categoriaController.buscarCategoriaPorNome(nomeCategoria);
        if(categoria.isPresent()) {
            this.categoriaController.excluirCategoria(categoria.get());
        }else{
            System.out.println("Categoria nao existe");
        }
    }

    public Optional<Categoria> buscarCategoriaPorId(String nomeCategoria) {
        return this.categoriaController.buscarCategoriaPorNome(nomeCategoria);
    }

    public List<Categoria> listarCategorias(){
        return this.categoriaController.getListaCategoria();
    }
}
