package controllers;

import model.Atrasos;
import model.Livro;
import model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
}
