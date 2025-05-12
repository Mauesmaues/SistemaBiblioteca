package org.example;

import controllers.*;
import controllers.AutorController;
import controllers.CategoriaController;
import controllers.LivroController;
import controllers.UsuarioController;
import controllers.EmprestimoController;
import controllers.DevolucaoController;
import model.Usuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PreCarga {

    private final AutorController autorController;
    private final CategoriaController categoriaController;
    private final LivroController livroController;
    private final UsuarioController usuarioController;
    private final EmprestimoController emprestimoController;
    private final DevolucaoController devolucaoController;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public PreCarga() {

        autorController = new AutorController();
        categoriaController = new CategoriaController();
        livroController = new LivroController();
        usuarioController = new UsuarioController();
        emprestimoController = new EmprestimoController();
        devolucaoController = new DevolucaoController();

        carregarAutores();
        carregarCategorias();
        carregarLivros();
        carregarUsuarios();
        carregarEmprestimos();
        carregarDevolucoes();
    }

    private void carregarAutores() {
        autorController.cadastrarAutor("J.K. Rowling", "31/07/1965", "Britânica", "ATIVO");
        autorController.cadastrarAutor("George Orwell", "25/06/1903", "Britânico", "ATIVO");
        autorController.cadastrarAutor("Machado de Assis", "21/06/1839", "Brasileiro", "ATIVO");
        autorController.cadastrarAutor("Clarice Lispector", "10/12/1920", "Brasileira", "ATIVO");
        autorController.cadastrarAutor("Gabriel García Márquez", "06/03/1927", "Colombiano", "ATIVO");
        autorController.cadastrarAutor("Jane Austen", "16/12/1775", "Britânica", "ATIVO");
    }

    private void carregarCategorias() {
        categoriaController.cadastrarCategoria("Fantasia", "Livros de fantasia e mundos imaginários");
        categoriaController.cadastrarCategoria("Ficção Científica", "Livros de ficção científica e futurismo");
        categoriaController.cadastrarCategoria("Romance", "Livros de histórias românticas");
        categoriaController.cadastrarCategoria("Literatura Brasileira", "Livros de autores brasileiros");
        categoriaController.cadastrarCategoria("Drama", "Livros com histórias dramáticas");
        categoriaController.cadastrarCategoria("Clássicos", "Livros considerados clássicos da literatura mundial");
    }


    private void carregarLivros() {

        livroController.cadastrarLivro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "26/06/1997", 5, "Fantasia");
        livroController.cadastrarLivro("1984", "George Orwell", "08/06/1949", 3, "Ficção Científica");
        livroController.cadastrarLivro("Dom Casmurro", "Machado de Assis", "01/01/1899", 4, "Literatura Brasileira");
        livroController.cadastrarLivro("A Hora da Estrela", "Clarice Lispector", "01/01/1977", 2, "Literatura Brasileira");
        livroController.cadastrarLivro("Cem Anos de Solidão", "Gabriel García Márquez", "01/01/1967", 3, "Drama");
        livroController.cadastrarLivro("Orgulho e Preconceito", "Jane Austen", "28/01/1813", 2, "Clássicos");
    }


    private void carregarUsuarios() {
        usuarioController.cadastrarUsuario("Carlos Silva", "(11) 98765-4321", "Rua das Flores, 123", "carlos.silva@email.com");
        usuarioController.cadastrarUsuario("Maria Oliveira", "(21) 97654-3210", "Av. Principal, 456", "maria.oliveira@email.com");
        usuarioController.cadastrarUsuario("João Santos", "(31) 96543-2109", "Praça Central, 789", "joao.santos@email.com");
        usuarioController.cadastrarUsuario("Ana Lima", "(41) 95432-1098", "Rua das Árvores, 321", "ana.lima@email.com");
        usuarioController.cadastrarUsuario("Pedro Almeida", "(51) 94321-0987", "Av. Secundária, 654", "pedro.almeida@email.com");
    }

    private void carregarEmprestimos() {

        emprestimoController.cadastrarEmprestimo( "Carlos Silva", "Harry Potter e a Pedra Filosofal");
        emprestimoController.cadastrarEmprestimo( "Maria Oliveira", "1984");

        emprestimoController.cadastrarEmprestimo( "Pedro Almeida", "Dom Casmurro");
    }

    private void carregarDevolucoes() {
        devolucaoController.registrarDevolucao("Maria Oliveira", "14/05/2025");

        devolucaoController.registrarDevolucao("Pedro Almeida", "22/05/2025");
    }
}
