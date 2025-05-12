package controllers;

import model.Atrasos;
import model.Livro;
import model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import factory.AtrasosFactory;

public class AtrasosController {
    private static List<Atrasos> atrasos;

    public AtrasosController() {
        atrasos = new ArrayList<Atrasos>();
    }

    public static void cadastrarAtraso(int id, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, Usuario usuario, Livro livro,
                   LocalDate dataDevoluca) {
            Atrasos atraso = AtrasosFactory.criarAtrasos(id, dataEmprestimo, dataPrevistaDevolucao, usuario, livro, dataDevoluca);
            atrasos.add(atraso);
    }

    public static List<String> listarLivrosEntreguesEmAtraso() {
        return atrasos.stream().map(atrasos -> atrasos.getLivro().getTitulo()).toList();
    }

    public static List<String> listarUsuariosComDevolucoesComAtraso() {
        return  atrasos.stream().map(atrasos -> atrasos.getUsuario().getNome()).toList();
    }
}
