package view;

import java.util.Scanner;

import controllers.UsuarioController;

public class UsuarioView {
    private final UsuarioController usuarioController;
    private final Scanner scanner;

    public UsuarioView() {
        this.usuarioController = new UsuarioController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu de Usuários ===");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Excluir Usuário");
            System.out.println("3. Alterar Usuário");
            System.out.println("4. Buscar Usuário por Nome");
            System.out.println("5. Ordenar Usuários");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> cadastrarUsuario();
                case 2 -> excluirUsuario();
                case 3 -> alterarUsuario();
                case 4 -> buscarUsuario();
                case 5 -> ordenarUsuarios();
                case 0 -> System.out.println("Saindo do menu de usuários...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void cadastrarUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o telefone do usuário: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o endereço do usuário: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o e-mail do usuário: ");
        String email = scanner.nextLine();
        System.out.println(usuarioController.cadastrarUsuario(nome, telefone, endereco, email));
    }

    private void excluirUsuario() {
        System.out.print("Digite o nome do usuário a ser excluído: ");
        String nome = scanner.nextLine();
        System.out.println(usuarioController.excluirUsuario(nome));
    }

    private void alterarUsuario() {
        System.out.print("Digite o nome do usuário a ser alterado: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o novo nome do usuário: ");
        String novoNome = scanner.nextLine();
        System.out.print("Digite o telefone do usuário: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o endereço do usuário: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o e-mail do usuário: ");
        String email = scanner.nextLine();
        System.out.println(usuarioController.alterarUsuario(nome, novoNome, telefone, endereco, email));
    }

    private void buscarUsuario() {
        System.out.print("Digite o nome do usuário para buscar: ");
        String nome = scanner.nextLine();
        var usuario = usuarioController.buscarUsuario(nome);
        if (usuario.isPresent()) {
            System.out.println("Usuário encontrado: " + usuario.get());
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    private void ordenarUsuarios() {
        usuarioController.ordenarUsuario();
        System.out.println("Usuários ordenados com sucesso!");
    }
}