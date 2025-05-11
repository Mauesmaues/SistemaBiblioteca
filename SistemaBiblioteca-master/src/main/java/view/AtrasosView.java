package view;

import java.util.Scanner;

import controllers.EmprestimoController;

public class AtrasosView {
    private final EmprestimoController emprestimoController;
    private final Scanner scanner;

    public AtrasosView() {
        this.emprestimoController = new EmprestimoController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu de Atrasos ===");
            System.out.println("1. Listar Empréstimos Atrasados");
            System.out.println("2. Listar Usuários com Devoluções Atrasadas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> {
                    System.out.println("\n=== Empréstimos Atrasados ===");
                    System.out.println(emprestimoController.listarEmprestimosAtivos());
                }
                case 2 -> {
                    System.out.println("\n=== Usuários com Devoluções Atrasadas ===");
                    System.out.println(emprestimoController.usuariosComDevolucoesAtrasadas());
                }
                case 0 -> System.out.println("Saindo do menu de atrasos...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}