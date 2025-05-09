package controllers;

import entities.Categoria;
import factory.CategoriaFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoriaController {
    List<Categoria> listaCategoria;

    public CategoriaController() {
        listaCategoria = new ArrayList<>();
    }

    public String cadastrarCategoria(String nomeCategoria, String descricao) {
        if (buscarCategoria(nomeCategoria).isEmpty()) {
            Optional<Categoria> categoria = CategoriaFactory.criarCategoria(nomeCategoria, descricao);
            if (categoria.isPresent()) {
                listaCategoria.add(categoria.get());
                return "Categoria cadastrada com sucesso!";
            }
            return "Categoria invalida!";
        }
        return "Categoria ja existente!";
    }

    public String excluirCategoria(String nomeCategoria) {
        if(buscarCategoria(nomeCategoria).isEmpty()){
            return "categoria nao encontrada!";
        }
        listaCategoria.remove(buscarCategoria(nomeCategoria).get());
        return "Categoria excluido com sucesso!";
    }

    public Optional<Categoria> buscarCategoria(String nome) {
        for (Categoria categoria : listaCategoria) {
            if(categoria.getNomeCategoria().equals(nome)) {
                return Optional.of(categoria);
            }
        }
        return Optional.empty();
    }

    public void ordenarCategoria() {
        Collections.sort(listaCategoria);
    }

    public List<String> listarCategorias() {
        return this.listaCategoria.stream().map(Categoria::getNomeCategoria).collect(Collectors.toList());
    }
}
