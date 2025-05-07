package controllers;

import entities.Categoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaController {
    List<Categoria> listaCategoria;

    public CategoriaController() {
        listaCategoria = new ArrayList<>();
    }

    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public void cadastrarCategoria(Categoria categoria) {
        listaCategoria.add(categoria);
    }

    public void excluirCategoria(Categoria categoria) {
        listaCategoria.remove(categoria);
    }

    public Optional<Categoria> buscarCategoriaPorNome(String nome) {
        for (Categoria categoria : listaCategoria) {
            if(categoria.getNomeCategoria().equals(nome)) {
                return Optional.of(categoria);
            }
        }
        return Optional.empty();
    }
}
