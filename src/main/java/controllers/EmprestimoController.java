package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import enums.StatusEmprestimo;
import factory.EmprestimoFactory;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class EmprestimoController {

    private static List<Emprestimo> emprestimos;

    public EmprestimoController() {
        this.emprestimos = new ArrayList<Emprestimo>();
    }

    public String cadastrarEmprestimo(
            String usuario, String livro) {

        int id = 0;
        if (!emprestimos.isEmpty()) {
            id = emprestimos.getLast().getId() + 1;
        }

        if (UsuarioController.buscarUsuario(usuario).isEmpty()) {
            return "Usuario não encontrado!";
        }

        if (buscarEmprestimoUser(usuario).isPresent()) {
            return "Usuario ja possui um emprestimo ativo!";
        }

        if (LivroController.pesquisarLivroNome(livro).isEmpty()) {
            return "Livro não encontrado!";
        }

        if (LivroController.pesquisarLivroNome(livro).get().getExemplaresDisponiveis() == 0) {
            return "Livro indisponivel!";
        }

        Livro livroEmprestimo = LivroController.pesquisarLivroNome(livro).get();
        Usuario usuarioEmprestimo = UsuarioController.buscarUsuario(usuario).get();
        livroEmprestimo.setExemplaresDisponiveis(livroEmprestimo.getExemplaresDisponiveis() - 1);
        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataPrevistaDevolucao = dataEmprestimo.plusDays(7);

        Emprestimo emprestimo = EmprestimoFactory.criarEmprestimo(id, dataEmprestimo, dataPrevistaDevolucao, usuarioEmprestimo, livroEmprestimo).get();
        this.emprestimos.add(emprestimo);
        return "Emprestimo criado com sucesso!";
    }

    public static Optional<Emprestimo> buscarEmprestimoUser(String nomeUsuario) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().getNome().equalsIgnoreCase(nomeUsuario)) {
                return Optional.of(emprestimo);
            }
        }
        return Optional.empty();
    }

    public Optional<Emprestimo> excluirEmprestimo() {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getDataPrevistaDevolucao().isBefore(LocalDate.now())) {
                emprestimos.remove(emprestimo);
                return Optional.of(emprestimo);
            }
        }
        return Optional.empty();
    }

    public static Optional<Emprestimo> buscarEmprestimoId(int id) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getId() == id) {
                return Optional.of(emprestimo);
            }
        }
        return Optional.empty();
    }

    public static List<Emprestimo> listarEmprestimos() {
        atualizarAtrasos();
        return emprestimos;
    }

    public static void atualizarAtrasos() {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getDataPrevistaDevolucao().isBefore(LocalDate.now()) && emprestimo.getStatusEmprestimo() != StatusEmprestimo.DEVOLVIDO) {
                emprestimo.setStatusEmprestimo(StatusEmprestimo.valueOf("ATRASADO"));
            }
        }
    }

    public static List<String> listarEmprestimosAtivos() {
        atualizarAtrasos();
        return emprestimos.stream()
                .filter(emprestimo -> emprestimo.getStatusEmprestimo() == StatusEmprestimo.EMPRESTADO || emprestimo.getStatusEmprestimo() == StatusEmprestimo.ATRASADO)
                .map(emprestimo -> emprestimo.getLivro().getTitulo())
                .toList();
    }

    public static List<String> usuariosComDevolucoesAtrasadas() {
        atualizarAtrasos();
        return listarEmprestimos().stream()
                .filter(emprestimo -> emprestimo.getStatusEmprestimo() == StatusEmprestimo.ATRASADO)
                .map(emprestimo -> emprestimo.getUsuario().getNome())
                .toList();
    }

    public static List<String> listarLivrosPopulares() {
        return emprestimos.stream()
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
