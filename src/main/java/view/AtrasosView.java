package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controllers.AtrasosController;
import controllers.LivroController;
import controllers.UsuarioController;
import model.Livro;
import model.Usuario;

public class AtrasosView {
    private final AtrasosController atrasosController;
    private final UsuarioController usuarioController;
    private final LivroController livroController;
    private final Scanner scanner;

    public AtrasosView() {
        this.atrasosController = new AtrasosController();
        this.usuarioController = new UsuarioController();
        this.livroController = new LivroController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu de Atrasos ===");
            System.out.println("1. Cadastrar Atraso");
            System.out.println("2. Listar Usuários com Devoluções Atrasadas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> cadastrarAtraso();
                case 2 -> listarUsuariosComDevolucoesAtrasadas();
                case 0 -> System.out.println("Saindo do menu de atrasos...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void cadastrarAtraso() {
        System.out.print("Digite o ID do atraso: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Digite a data do empréstimo (formato dd/MM/yyyy): ");
        String dataEmprestimoStr = scanner.nextLine();
        LocalDate dataEmprestimo = LocalDate.parse(dataEmprestimoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Digite a data prevista de devolução (formato dd/MM/yyyy): ");
        String dataPrevistaDevolucaoStr = scanner.nextLine();
        LocalDate dataPrevistaDevolucao = LocalDate.parse(dataPrevistaDevolucaoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Digite a data de devolução (formato dd/MM/yyyy): ");
        String dataDevolucaoStr = scanner.nextLine();
        LocalDate dataDevolucao = LocalDate.parse(dataDevolucaoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Digite o nome do usuário: ");
        String usuarioNome= scanner.nextLine();

        System.out.print("Digite o título do livro: ");
        String tituloLivro = scanner.nextLine();

        // Obter o usuário e o livro
        Usuario usuario = usuarioController.buscarUsuario(usuarioNome).orElse(null);
        Livro livro = livroController.pesquisarLivroNome(tituloLivro).orElse(null);

        if (usuario == null) {
            System.out.println("Usuário não encontrado. Não é possível cadastrar o atraso.");
            return;
        }

        if (livro == null) {
            System.out.println("Livro não encontrado. Não é possível cadastrar o atraso.");
            return;
        }

        atrasosController.cadastrarAtraso(id, dataEmprestimo, dataPrevistaDevolucao, usuario, livro, dataDevolucao);
        System.out.println("Atraso cadastrado com sucesso!");
    }

    private void listarUsuariosComDevolucoesAtrasadas() {
        System.out.println("\n=== Usuários com Devoluções Atrasadas ===");
        // Aqui você pode implementar a lógica para listar usuários com devoluções atrasadas
    }
}