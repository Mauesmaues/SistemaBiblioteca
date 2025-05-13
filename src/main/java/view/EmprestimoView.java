package view;

import java.util.Scanner;

import controllers.EmprestimoController;

public class EmprestimoView {

    private final EmprestimoController emprestimoController;
    private final Scanner scanner;

    public EmprestimoView(EmprestimoController emprestimoController) {
        this.emprestimoController = emprestimoController;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu de Empréstimos ===");
            System.out.println("1. Registrar Empréstimo");
            System.out.println("2. Buscar Empréstimo por Usuário");
            System.out.println("3. Buscar Empréstimo por ID");
            System.out.println("4. Listar Todos os Empréstimos");
            System.out.println("5. Atualizar Atrasos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 ->
                    registrarEmprestimo();
                case 2 ->
                    buscarEmprestimoPorUsuario();
                case 3 ->
                    buscarEmprestimoPorId();
                case 4 ->
                    listarTodosEmprestimos();
                case 5 ->
                    atualizarAtrasos();
                case 0 ->
                    System.out.println("Saindo do menu de empréstimos...");
                default ->
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void registrarEmprestimo() {

        System.out.print("Digite o nome do usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Digite o título do livro: ");
        String livro = scanner.nextLine();
        System.out.println(emprestimoController.cadastrarEmprestimo(usuario, livro));
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
        scanner.nextLine();
        var emprestimo = EmprestimoController.buscarEmprestimoId(id);
        if (emprestimo.isPresent()) {
            System.out.println("Empréstimo encontrado: " + emprestimo.get());
        } else {
            System.out.println("Nenhum empréstimo encontrado para o ID informado.");
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
