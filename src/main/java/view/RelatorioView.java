package view;

import java.util.Scanner;

import service.Relatorio;

public class RelatorioView {
    private final Scanner scanner;

    public RelatorioView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu de Relatórios ===");
            System.out.println("1. Listar Empréstimos Ativos");
            System.out.println("2. Listar Usuários com Devoluções em  Atraso");
            System.out.println("3. Listar Livros Populares");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> listarEmprestimosAtivos();
                case 2 -> listarUsuariosComDevolucoesAtrasadas();
                case 3 -> listarLivrosPopulares();
                case 0 -> System.out.println("Saindo do menu de relatórios...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void listarEmprestimosAtivos() {
        System.out.println("\n=== Empréstimos Ativos ===");
        Relatorio.listarEmprestimosAtivos().forEach(System.out::println);
    }

    private void listarUsuariosComDevolucoesAtrasadas() {
        System.out.println("\n=== Usuários com Devoluções em Atraso ===");
        Relatorio.usuariosComDevolucoesAtrasadas().forEach(System.out::println);
    }

    private void listarLivrosPopulares() {
        System.out.println("\n=== Livros Populares ===");
        Relatorio.listarLivrosPopulares().forEach(System.out::println);
    }
}