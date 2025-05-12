package view;

import java.util.Scanner;

import controllers.LivroController;

public final class LivroView {
    private final LivroController livroController;
    private final Scanner scanner;

    public LivroView() {
        this.livroController = new LivroController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu de Livros ===");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Alterar Livro");
            System.out.println("3. Excluir Livro");
            System.out.println("4. Listar Livros");
            System.out.println("5. Ordenar Livros");
            System.out.println("6. Pesquisar Livro por ID");
            System.out.println("7. Pesquisar Livro por Nome");
            System.out.println("8. Pesquisar Livros por Autor");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> cadastrarLivro();
                case 2 -> alterarLivro();
                case 3 -> excluirLivro();
                case 4 -> listarLivros();
                case 5 -> ordenarLivros();
                case 6 -> pesquisarLivroPorId();
                case 7 -> pesquisarLivroPorNome();
                case 8 -> pesquisarLivrosPorAutor();
                case 0 -> System.out.println("Saindo do menu de livros...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void cadastrarLivro() {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o nome do autor: ");
        String autor = scanner.nextLine();
        System.out.print("Digite a data de publicação (formato dd/MM/yyyy): ");
        String dataPublicacao = scanner.nextLine();
        System.out.print("Digite o número de exemplares disponíveis: ");
        int exemplaresDisponiveis = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Digite o nome da categoria: ");
        String categoria = scanner.nextLine();

        String resultado = livroController.cadastrarLivro(titulo, autor, dataPublicacao, exemplaresDisponiveis, categoria);
        System.out.println(resultado);
    }

    private void alterarLivro() {
        System.out.print("Digite o título do livro a ser alterado: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o novo título do livro: ");
        String novoTitulo = scanner.nextLine();
        System.out.print("Digite o nome do autor: ");
        String autor = scanner.nextLine();
        System.out.print("Digite a nova data de publicação (formato dd/MM/yyyy): ");
        String dataPublicacao = scanner.nextLine();
        System.out.print("Digite o número de exemplares disponíveis: ");
        int exemplaresDisponiveis = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Digite o nome da categoria: ");
        String categoria = scanner.nextLine();

        String resultado = livroController.alterarLivro(titulo, novoTitulo, autor, dataPublicacao, exemplaresDisponiveis, categoria);
        System.out.println(resultado);
    }

    private void excluirLivro() {
        System.out.print("Digite o título do livro a ser excluído: ");
        String titulo = scanner.nextLine();

        String resultado = livroController.excluirLivro(titulo);
        System.out.println(resultado);
    }

    private void listarLivros() {
        System.out.println("Lista de livros:");
        livroController.listarLivros().forEach(System.out::println);
    }

    private void ordenarLivros() {
        livroController.ordenarLivros();
        System.out.println("Livros ordenados com sucesso!");
    }

    private void pesquisarLivroPorId() {
        System.out.print("Digite o ID do livro: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        var livro = livroController.pesquisarLivroId(id);
        if (livro.isPresent()) {
            System.out.println("Livro encontrado: " + livro.get());
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private void pesquisarLivroPorNome() {
        System.out.print("Digite o nome do livro: ");
        String titulo = scanner.nextLine();

        var livro = LivroController.pesquisarLivroNome(titulo);
        if (livro.isPresent()) {
            System.out.println("Livro encontrado: " + livro.get());
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private void pesquisarLivrosPorAutor() {
        System.out.print("Digite o nome do autor: ");
        String autor = scanner.nextLine();

        var livros = livroController.pesquisarLivrosAutor(autor);
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado para o autor informado.");
        } else {
            System.out.println("Livros encontrados:");
            livros.forEach(System.out::println);
        }
    }
}