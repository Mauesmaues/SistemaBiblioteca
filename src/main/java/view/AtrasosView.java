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
    private final Scanner scanner;
    public AtrasosView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu de Atrasos ===");
            System.out.println("1. Listar Usuários que fizeram devoluções em atraso");
            System.out.println("2. Listar livros entregues em atraso");
            System.out.println("3. Ordenar atrasos em ordem descrescente de dias de atraso");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> System.out.println(AtrasosController.listarUsuariosComDevolucoesComAtraso());
                case 2 -> System.out.println(AtrasosController.listarLivrosEntreguesEmAtraso());
                case 3 -> {
                    AtrasosController.ordenarAtrasosEmOrdemDecrescente();
                    System.out.println("Ordenado em ordem decrescente de dias de atraso");
                }
                case 0 -> System.out.println("Saindo do menu de atrasos...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}