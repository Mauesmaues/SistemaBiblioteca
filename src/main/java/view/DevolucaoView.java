package view;

import java.util.Scanner;

import controllers.DevolucaoController;

public class DevolucaoView {
    private final DevolucaoController devolucaoController;
    private final Scanner scanner;

    public DevolucaoView(DevolucaoController devolucaoController) {
        this.devolucaoController = devolucaoController;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu de Devoluções ===");
            System.out.println("1. Registrar Devolução");
            System.out.println("2. Listar Devoluções");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o nome do usuário: ");
                    String usuario = scanner.nextLine();
                    System.out.print("Digite a data de devolução (formato dd/MM/yyyy): ");
                    String dataDevolucao = scanner.nextLine();
                    System.out.println(devolucaoController.registrarDevolucao(usuario, dataDevolucao));
                }
                case 2 -> devolucaoController.listarDevolucaos().forEach(System.out::println);
                case 0 -> System.out.println("Saindo do menu de devoluções...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}