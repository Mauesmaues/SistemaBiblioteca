package view;

import java.util.Scanner;

import controllers.AutorController;

public final class AutorView {
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
            System.out.println("5. Alterar Autor");
            System.out.println("6. Ordenar Autores");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarAutor();
                case 2 -> listarAutores();
                case 3 -> buscarAutor();
                case 4 -> excluirAutor();
                case 5 -> alterarAutor();
                case 6 -> ordenarAutores();
                case 0 -> System.out.println("Saindo do menu de autores...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void cadastrarAutor() {
        System.out.print("Digite o nome do autor: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a data de nascimento do autor (formato dd/MM/yyyy): ");
        String dataNasc = scanner.nextLine();
        System.out.print("Digite a nacionalidade do autor: ");
        String nacionalidade = scanner.nextLine();
        System.out.print("Digite o status do autor (ATIVO/INATIVO): ");
        String status = scanner.nextLine();
        System.out.println(autorController.cadastrarAutor(nome, dataNasc, nacionalidade, status));
    }

    private void listarAutores() {
        System.out.println("\n=== Lista de Autores ===");
        autorController.listarAutors().forEach(System.out::println);
    }

    private void buscarAutor() {
        System.out.print("Digite o nome do autor para buscar: ");
        String nome = scanner.nextLine();
        var autor = AutorController.buscarAutor(nome);
        if (autor.isPresent()) {
            System.out.println("Autor encontrado: " + autor.get());
        } else {
            System.out.println("Autor não encontrado.");
        }
    }

    private void excluirAutor() {
        System.out.print("Digite o nome do autor para excluir: ");
        String nome = scanner.nextLine();
        System.out.println(autorController.excluirAutor(nome));
    }

    private void alterarAutor() {
        System.out.print("Digite o nome do autor a ser alterado: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o  novo nome do autor a ser alterado: ");
        String novoNome = scanner.nextLine();
        System.out.print("Digite a nova data de nascimento do autor (formato dd/MM/yyyy): ");
        String dataNasc = scanner.nextLine();
        System.out.print("Digite a nova nacionalidade do autor: ");
        String nacionalidade = scanner.nextLine();
        System.out.print("Digite o novo status do autor (ATIVO/INATIVO): ");
        String status = scanner.nextLine().toUpperCase();
        System.out.println(autorController.alterarAutor(nome, novoNome, dataNasc, nacionalidade, status));
    }

    private void ordenarAutores() {
        autorController.ordenarAutors();
        System.out.println("Autores ordenados com sucesso!");
    }
}