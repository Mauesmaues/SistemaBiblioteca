package view;

import java.util.Scanner;

import controllers.*;

public class ViewGeral {
    private final CategoriaView categoriaView;
    private final AutorView autorView;
    private final UsuarioView usuarioView;
    private final LivroView livroView;
    private final EmprestimoView emprestimoView;
    private final DevolucaoView devolucaoView;
    private final AtrasosView atrasosView;
    private final RelatorioView relatorioView;
    private final Scanner scanner;    

    public ViewGeral(AutorController autorController,CategoriaController categoriaController,LivroController livroController,UsuarioController usuarioController,EmprestimoController emprestimoController,DevolucaoController devolucaoController, AtrasosController atrasosController) {
        this.categoriaView = new CategoriaView(categoriaController);
        this.autorView = new AutorView(autorController);
        this.usuarioView = new UsuarioView(usuarioController);
        this.livroView = new LivroView(livroController);
        this.emprestimoView = new EmprestimoView(emprestimoController);
        this.devolucaoView = new DevolucaoView(devolucaoController);
        this.atrasosView = new AtrasosView(atrasosController);
        this.relatorioView = new RelatorioView();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n=== Sistema Biblioteca ===");
            System.out.println("1. Menu de Categorias");
            System.out.println("2. Menu de Autores");
            System.out.println("3. Menu de Usuários");
            System.out.println("4. Menu de Livros");
            System.out.println("5. Menu de Empréstimos");
            System.out.println("6. Menu de Devoluções");
            System.out.println("7. Menu de Atrasos");
            System.out.println("8. Menu de Relatórios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> categoriaView.exibirMenu();
                case 2 -> autorView.exibirMenu();
                case 3 -> usuarioView.exibirMenu();
                case 4 -> livroView.exibirMenu();
                case 5 -> emprestimoView.exibirMenu();
                case 6 -> devolucaoView.exibirMenu();
                case 7 -> atrasosView.exibirMenu();
                case 8 -> relatorioView.exibirMenu();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}