package controllers;

import model.Atraso;
import model.Devolucao;
import model.Livro;
import model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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

    public static List<Livro> listarLivrosEntreguesEmAtraso() {
        return atrasos.stream().map(Devolucao::getLivro).toList();
    }

    public static List<Usuario> listarUsuariosComDevolucoesComAtraso() {
        return  atrasos.stream().map(Devolucao::getUsuario).toList();
    }

    public static void ordenarAtrasosEmOrdemDecrescente() {
        Collections.sort(atrasos, Collections.reverseOrder());
    }
}
