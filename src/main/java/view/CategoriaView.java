package view;

import java.util.Scanner;

import controllers.CategoriaController;

public final class CategoriaView {
    private final CategoriaController categoriaController;
    private final Scanner scanner;

    public CategoriaView(CategoriaController categoriaController) {
        this.categoriaController = categoriaController;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu de Categorias ===");
            System.out.println("1. Cadastrar Categoria");
            System.out.println("2. Listar Categorias");
            System.out.println("3. Buscar Categoria por Nome");
            System.out.println("4. Excluir Categoria");
            System.out.println("5. Ordenar Categorias");
            System.out.println("6. Alterar Categoria");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> cadastrarCategoria();
                case 2 -> listarCategorias();
                case 3 -> buscarCategoria();
                case 4 -> excluirCategoria();
                case 5 -> ordenarCategorias();
                case 0 -> System.out.println("Saindo do menu de categorias...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void cadastrarCategoria() {
        System.out.print("Digite o nome da categoria: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a descrição da categoria: ");
        String descricao = scanner.nextLine();
        System.out.println(categoriaController.cadastrarCategoria(nome, descricao));
    }

    private void listarCategorias() {
        System.out.println("\n=== Lista de Categorias ===");
        System.out.println(categoriaController.listarCategorias());
    }

    private void buscarCategoria() {
        System.out.print("Digite o nome da categoria para buscar: ");
        String nome = scanner.nextLine();
        System.out.println(categoriaController.buscarCategoria(nome));
    }

    private void excluirCategoria() {
        System.out.print("Digite o nome da categoria para excluir: ");
        String nome = scanner.nextLine();
        System.out.println(categoriaController.excluirCategoria(nome));
    }

    private void ordenarCategorias() {
        categoriaController.ordenarCategoria();
        System.out.println("Categorias ordenadas com sucesso!");
    }

    private void alterarCategoria() {
        System.out.print("Digite o nome da categoria alterada: ");
        String categoria = scanner.nextLine();
        System.out.print("Digite o novo nome da categoria: ");
        String novoNome = scanner.nextLine();
        System.out.print("Digite a nova descrição da categoria: ");
        String descricao = scanner.nextLine();

        String resultado = categoriaController.alterarCategoria(categoria, novoNome, descricao);
        System.out.println(resultado);
    }
}