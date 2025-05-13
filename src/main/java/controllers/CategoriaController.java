package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import factory.CategoriaFactory;
import model.Categoria;

public class CategoriaController {

    private static List<Categoria> listaCategoria;

    public CategoriaController() {
        listaCategoria = new ArrayList<>();
    }

    public String cadastrarCategoria(String nomeCategoria, String descricao) {

        if (buscarCategoria(nomeCategoria).isPresent()) { return "Categoria ja existente!"; }
        if (nomeCategoria.isEmpty()) { return "Campo nome em branco!"; }
        if (descricao.isEmpty()) { return "Campo descricao em branco!"; }

        Categoria categoria = CategoriaFactory.criarCategoria(nomeCategoria, descricao);
        listaCategoria.add(categoria);
        return "Categoria cadastrada com sucesso!";
    }

    public String excluirCategoria(String nomeCategoria) {
        if (buscarCategoria(nomeCategoria).isEmpty()) {
            return "categoria nao encontrada!";
        }
        listaCategoria.remove(buscarCategoria(nomeCategoria).get());
        return "Categoria excluido com sucesso!";
    }

    public static Optional<Categoria> buscarCategoria(String nome) {
        for (Categoria categoria : listaCategoria) {
            if (categoria.getNomeCategoria().equalsIgnoreCase(nome)) {
                return Optional.of(categoria);
            }
        }
        return Optional.empty();
    }

    public String alterarCategoria(String nomeCategoria, String novoNome, String descricao) {

        if (buscarCategoria(nomeCategoria).isEmpty()) { return "Categoria nao encontrada!"; }
        if (novoNome.isEmpty()) { return "Campo nome novo em branco!"; }
        if (descricao.isEmpty()) { return "Campo descricao em branco!"; }

        buscarCategoria(nomeCategoria).ifPresent(categoria -> {
            categoria.setNomeCategoria(novoNome);
            categoria.setDescricaoCategoria(descricao);
        });
        return "Categoria alterada com sucesso!";
    }

    public void ordenarCategoria() {
        Collections.sort(listaCategoria);
    }

    public List<Categoria> listarCategorias() {
        return listaCategoria;
    }
}
