package controllers;

import model.Atraso;
import model.Livro;
import model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import factory.AtrasosFactory;

public class AtrasosController {
    private static List<Atraso> atrasos = new ArrayList<Atraso>();

    public AtrasosController() {}

    public static void cadastrarAtraso(int id, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, Usuario usuario, Livro livro,
                   LocalDate dataDevolucao) {
            Atraso atraso = AtrasosFactory.criarAtrasos(id, dataEmprestimo, dataPrevistaDevolucao, usuario, livro, dataDevolucao);
            atrasos.add(atraso);
    }

    public static List<String> listarLivrosEntreguesEmAtraso() {
        return atrasos.stream().map(atrasos -> atrasos.getLivro().getTitulo()).toList();
    }

    public static List<String> listarUsuariosComDevolucoesComAtraso() {
        return  atrasos.stream().map(atrasos -> atrasos.getUsuario().getNome()).toList();
    }
}
