package view;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import controllers.EmprestimoController;

public class EmprestimoView {
    private final EmprestimoController emprestimoController;
    private final Scanner scanner;

    public EmprestimoView() {
        this.emprestimoController = new EmprestimoController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu de Empréstimos ===");
            System.out.println("1. Registrar Empréstimo");
            System.out.println("2. Buscar Empréstimo por Usuário");
            System.out.println("3. Buscar Empréstimo por ID");
            System.out.println("4. Excluir Empréstimo");
            System.out.println("5. Listar Todos os Empréstimos");
            System.out.println("6. Atualizar Atrasos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> registrarEmprestimo();
                case 2 -> buscarEmprestimoPorUsuario();
                case 3 -> buscarEmprestimoPorId();
                case 4 -> excluirEmprestimo();
                case 5 -> listarTodosEmprestimos();
                case 6 -> atualizarAtrasos();
                case 0 -> System.out.println("Saindo do menu de empréstimos...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void registrarEmprestimo() {
        try {
            System.out.print("Digite o nome do usuário: ");
            String usuario = scanner.nextLine();
            System.out.print("Digite o título do livro: ");
            String livro = scanner.nextLine();
            System.out.print("Digite a data do empréstimo (formato YYYY-MM-DD): ");
            LocalDate dataEmprestimo = LocalDate.parse(scanner.nextLine());
            System.out.print("Digite a data prevista de devolução (formato YYYY-MM-DD): ");
            LocalDate dataPrevistaDevolucao = LocalDate.parse(scanner.nextLine());
            System.out.println(emprestimoController.cadastrarEmprestimo(dataEmprestimo, dataPrevistaDevolucao, usuario, livro));
        } catch (DateTimeParseException e) {
            System.out.println("Erro: Data inválida. Use o formato YYYY-MM-DD.");
        } catch (Exception e) {
            System.out.println("Erro ao registrar empréstimo: " + e.getMessage());
        }
    }

    private void buscarEmprestimoPorUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String usuario = scanner.nextLine();
        var emprestimo = EmprestimoController.buscarEmprestimoUser(usuario);
        if (emprestimo.isPresent()) {
            System.out.println("Empréstimo encontrado: " + emprestimo.get());
        } else {
            System.out.println("Nenhum empréstimo encontrado para o usuário informado.");
        }
    }

    private void buscarEmprestimoPorId() {
        System.out.print("Digite o ID do empréstimo: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        var emprestimo = EmprestimoController.buscarEmprestimoId(id);
        if (emprestimo.isPresent()) {
            System.out.println("Empréstimo encontrado: " + emprestimo.get());
        } else {
            System.out.println("Nenhum empréstimo encontrado para o ID informado.");
        }
    }

    private void excluirEmprestimo() {
        var emprestimo = emprestimoController.excluirEmprestimo();
        if (emprestimo.isPresent()) {
            System.out.println("Empréstimo excluído: " + emprestimo.get());
        } else {
            System.out.println("Nenhum empréstimo foi excluído.");
        }
    }

    private void listarTodosEmprestimos() {
        System.out.println("\n=== Lista de Todos os Empréstimos ===");
        EmprestimoController.listarEmprestimos().forEach(System.out::println);
    }

    private void atualizarAtrasos() {
        EmprestimoController.atualizarAtrasos();
        System.out.println("Atrasos atualizados com sucesso!");
    }
}