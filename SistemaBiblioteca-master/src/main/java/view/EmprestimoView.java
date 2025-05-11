package view;

import java.time.LocalDate;
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
            System.out.println("2. Listar Empréstimos Ativos");
            System.out.println("3. Listar Livros Populares");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> registrarEmprestimo();
                case 2 -> listarEmprestimosAtivos();
                case 3 -> listarLivrosPopulares();
                case 0 -> System.out.println("Saindo do menu de empréstimos...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void registrarEmprestimo() {
        System.out.print("Digite o nome do usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Digite o título do livro: ");
        String livro = scanner.nextLine();
        System.out.print("Digite a data do empréstimo (formato YYYY-MM-DD): ");
        LocalDate dataEmprestimo = LocalDate.parse(scanner.nextLine());
        System.out.print("Digite a data prevista de devolução (formato YYYY-MM-DD): ");
        LocalDate dataPrevistaDevolucao = LocalDate.parse(scanner.nextLine());
        System.out.println(emprestimoController.cadastrarEmprestimo(dataEmprestimo, dataPrevistaDevolucao, usuario, livro));
    }

    private void listarEmprestimosAtivos() {
        System.out.println("\n=== Empréstimos Ativos ===");
        System.out.println(emprestimoController.listarEmprestimosAtivos());
    }

    private void listarLivrosPopulares() {
        System.out.println("\n=== Livros Populares ===");
        System.out.println(emprestimoController.listarLivrosPopulares());
    }
}