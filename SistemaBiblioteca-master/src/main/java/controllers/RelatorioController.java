package controllers;

import enums.StatusEmprestimo;

import java.util.List;


public class RelatorioController {

     public static List<String> listarEmprestimosAtivos() {
        return EmprestimoController.listarEmprestimos().stream()
            .filter(emprestimo -> emprestimo.getStatusEmprestimo() == StatusEmprestimo.EMPRESTADO || emprestimo.getStatusEmprestimo() == StatusEmprestimo.ATRASADO)
            .map(emprestimo -> emprestimo.getLivro().getTitulo())
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

