package view;

import java.util.Scanner;

import controllers.LivroController;

public class LivroView {
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
            System.out.println("2. Pesquisar Livro por ID");
            System.out.println("3. Pesquisar Livro por Nome");
            System.out.println("4. Pesquisar Livro por Autor");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> cadastrarLivro();
                case 2 -> pesquisarLivroPorId();
                case 3 -> pesquisarLivroPorNome();
                case 4 -> pesquisarLivroPorAutor();
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
        System.out.print("Digite a data de publicação (formato YYYY-MM-DD): ");
        String dataPublicacao = scanner.nextLine();
        System.out.print("Digite o número de exemplares disponíveis: ");
        int exemplaresDisponiveis = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Digite o nome da categoria: ");
        String categoria = scanner.nextLine();
        System.out.println(livroController.cadastrarLivro(titulo, autor, dataPublicacao, exemplaresDisponiveis, categoria));
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

    private void pesquisarLivroPorAutor() {
        System.out.print("Digite o nome do autor: ");
        String autor = scanner.nextLine();
        var livros = livroController.pesquisarLivroAutor(autor);
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado para o autor informado.");
        } else {
            System.out.println("Livros encontrados:");
            livros.forEach(System.out::println);
        }
    }
}