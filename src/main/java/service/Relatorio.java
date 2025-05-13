package service;

import java.util.List;

import controllers.EmprestimoController;
import enums.StatusEmprestimo;
import model.Emprestimo;

public class Relatorio {

    public static List<Emprestimo> listarEmprestimosAtivos() {
        return EmprestimoController.listarEmprestimos().stream()
                .filter(emprestimo -> emprestimo.getStatusEmprestimo() == StatusEmprestimo.EMPRESTADO || emprestimo.getStatusEmprestimo() == StatusEmprestimo.ATRASADO)
                .toList();
    }

    public static List<String> usuariosComDevolucoesAtrasadas() {
        return EmprestimoController.listarEmprestimos().stream()
                .filter(emprestimo -> emprestimo.getStatusEmprestimo() == StatusEmprestimo.ATRASADO)
                .map(emprestimo -> emprestimo.getUsuario().getNome())
                .toList();
    }

    public static List<String> listarLivrosPopulares() {
        return EmprestimoController.listarEmprestimos().stream()
                .collect(java.util.stream.Collectors.toMap(
                        e -> e.getLivro().getTitulo(),
                        e -> 1,
                        Integer::sum
                ))
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .map(entry -> entry.getKey() + " - " + entry.getValue() + " empréstimos")
                .toList();
    }

}
