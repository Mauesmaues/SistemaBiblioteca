package view;

import java.util.Scanner;

import controllers.AutorController;

public class AutorView {
    private final AutorController autorController;
    private final Scanner scanner;

    public AutorView() {
        this.autorController = new AutorController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu de Autores ===");
            System.out.println("1. Cadastrar Autor");
            System.out.println("2. Listar Autores");
            System.out.println("3. Buscar Autor por Nome");
            System.out.println("4. Excluir Autor");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> cadastrarAutor();
                case 2 -> listarAutores();
                case 3 -> buscarAutor();
                case 4 -> excluirAutor();
                case 0 -> System.out.println("Saindo do menu de autores...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void cadastrarAutor() {
        System.out.print("Digite o nome do autor: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a biografia do autor: ");
        String biografia = scanner.nextLine();
        System.out.print("Digite o email do autor: ");
        String email = scanner.nextLine();
        System.out.print("Digite o telefone do autor: ");
        String telefone = scanner.nextLine();
        System.out.println(autorController.cadastrarAutor(nome, biografia, email, telefone));
    }

    private void listarAutores() {
        System.out.println("\n=== Lista de Autores ===");
        System.out.println(autorController.listarAutors());
    }

    private void buscarAutor() {
        System.out.print("Digite o nome do autor para buscar: ");
        String nome = scanner.nextLine();
        System.out.println(autorController.buscarAutor(nome));
    }

    private void excluirAutor() {
        System.out.print("Digite o nome do autor para excluir: ");
        String nome = scanner.nextLine();
        System.out.println(autorController.excluirAutor(nome));
    }
}