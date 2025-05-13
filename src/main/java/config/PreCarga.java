package config;

import controllers.AutorController;
import controllers.CategoriaController;
import controllers.DevolucaoController;
import controllers.EmprestimoController;
import controllers.LivroController;
import controllers.UsuarioController;

/**
 * Classe responsável por realizar a pré-carga de dados para teste do sistema.
 * Adiciona autores, categorias, livros, usuários, empréstimos e devoluções.
 */
public class PreCarga {

    private final AutorController autorController;
    private final CategoriaController categoriaController;
    private final LivroController livroController;
    private final UsuarioController usuarioController;
    private final EmprestimoController emprestimoController;
    private final DevolucaoController devolucaoController;

    /**
     * Construtor que inicializa a pré-carga com os controllers fornecidos e
     * executa automaticamente o carregamento dos dados de teste.
     *
     * @param autorController Controller de autores
     * @param categoriaController Controller de categorias
     * @param livroController Controller de livros
     * @param usuarioController Controller de usuários
     * @param emprestimoController Controller de empréstimos
     * @param devolucaoController Controller de devoluções
     */
    public PreCarga(AutorController autorController, CategoriaController categoriaController, LivroController livroController,
            UsuarioController usuarioController, EmprestimoController emprestimoController, DevolucaoController devolucaoController) {

        this.autorController = autorController;
        this.categoriaController = categoriaController;
        this.livroController = livroController;
        this.usuarioController = usuarioController;
        this.emprestimoController = emprestimoController;
        this.devolucaoController = devolucaoController;

        System.out.println("\n========= INICIANDO PRÉ-CARGA DE DADOS =========\n");
        carregarAutores();
        carregarCategorias();
        carregarLivros();
        carregarUsuarios();
        carregarEmprestimos();
        carregarDevolucoes();
        System.out.println("\n========= PRÉ-CARGA CONCLUÍDA COM SUCESSO =========\n");
    }

    /**
     * Carrega dados iniciais de autores no sistema
     */
    private void carregarAutores() {
        System.out.println("-> Carregando autores...");
        String resultado;

        resultado = autorController.cadastrarAutor("J.K. Rowling", "31/07/1965", "Britânica", "ATIVO");
        System.out.println("   - J.K. Rowling: " + resultado);

        resultado = autorController.cadastrarAutor("George Orwell", "25/06/1903", "Britânico", "ATIVO");
        System.out.println("   - George Orwell: " + resultado);

        resultado = autorController.cadastrarAutor("Machado de Assis", "21/06/1839", "Brasileiro", "ATIVO");
        System.out.println("   - Machado de Assis: " + resultado);

        resultado = autorController.cadastrarAutor("Clarice Lispector", "10/12/1920", "Brasileira", "ATIVO");
        System.out.println("   - Clarice Lispector: " + resultado);

        resultado = autorController.cadastrarAutor("Gabriel García Márquez", "06/03/1927", "Colombiano", "ATIVO");
        System.out.println("   - Gabriel García Márquez: " + resultado);

        resultado = autorController.cadastrarAutor("Jane Austen", "16/12/1775", "Britânica", "ATIVO");
        System.out.println("   - Jane Austen: " + resultado);
    }

    /**
     * Carrega dados iniciais de categorias no sistema
     */
    private void carregarCategorias() {
        System.out.println("-> Carregando categorias...");
        String resultado;

        resultado = categoriaController.cadastrarCategoria("Fantasia", "Livros de fantasia e mundos imaginários");
        System.out.println("   - Fantasia: " + resultado);

        resultado = categoriaController.cadastrarCategoria("Ficção Científica", "Livros de ficção científica e futurismo");
        System.out.println("   - Ficção Científica: " + resultado);

        resultado = categoriaController.cadastrarCategoria("Romance", "Livros de histórias românticas");
        System.out.println("   - Romance: " + resultado);

        resultado = categoriaController.cadastrarCategoria("Literatura Brasileira", "Livros de autores brasileiros");
        System.out.println("   - Literatura Brasileira: " + resultado);

        resultado = categoriaController.cadastrarCategoria("Drama", "Livros com histórias dramáticas");
        System.out.println("   - Drama: " + resultado);

        resultado = categoriaController.cadastrarCategoria("Clássicos", "Livros considerados clássicos da literatura mundial");
        System.out.println("   - Clássicos: " + resultado);
    }

    /**
     * Carrega dados iniciais de livros no sistema
     */
    private void carregarLivros() {
        System.out.println("-> Carregando livros...");
        String resultado;

        resultado = livroController.cadastrarLivro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "26/06/1997", 5, "Fantasia");
        System.out.println("   - Harry Potter e a Pedra Filosofal: " + resultado);

        resultado = livroController.cadastrarLivro("1984", "George Orwell", "08/06/1949", 3, "Ficção Científica");
        System.out.println("   - 1984: " + resultado);

        resultado = livroController.cadastrarLivro("Dom Casmurro", "Machado de Assis", "01/01/1899", 4, "Literatura Brasileira");
        System.out.println("   - Dom Casmurro: " + resultado);

        resultado = livroController.cadastrarLivro("A Hora da Estrela", "Clarice Lispector", "01/01/1977", 2, "Literatura Brasileira");
        System.out.println("   - A Hora da Estrela: " + resultado);

        resultado = livroController.cadastrarLivro("Cem Anos de Solidão", "Gabriel García Márquez", "01/01/1967", 3, "Drama");
        System.out.println("   - Cem Anos de Solidão: " + resultado);

        resultado = livroController.cadastrarLivro("Orgulho e Preconceito", "Jane Austen", "28/01/1813", 2, "Clássicos");
        System.out.println("   - Orgulho e Preconceito: " + resultado);
    }

    /**
     * Carrega dados iniciais de usuários no sistema
     */
    private void carregarUsuarios() {
        System.out.println("-> Carregando usuários...");
        String resultado;

        resultado = usuarioController.cadastrarUsuario("Carlos Silva", "(11) 98765-4321", "Rua das Flores, 123", "carlos.silva@email.com");
        System.out.println("   - Carlos Silva: " + resultado);

        resultado = usuarioController.cadastrarUsuario("Maria Oliveira", "(21) 97654-3210", "Av. Principal, 456", "maria.oliveira@email.com");
        System.out.println("   - Maria Oliveira: " + resultado);

        resultado = usuarioController.cadastrarUsuario("João Santos", "(31) 96543-2109", "Praça Central, 789", "joao.santos@email.com");
        System.out.println("   - João Santos: " + resultado);

        resultado = usuarioController.cadastrarUsuario("Ana Lima", "(41) 95432-1098", "Rua das Árvores, 321", "ana.lima@email.com");
        System.out.println("   - Ana Lima: " + resultado);

        resultado = usuarioController.cadastrarUsuario("Pedro Almeida", "(51) 94321-0987", "Av. Secundária, 654", "pedro.almeida@email.com");
        System.out.println("   - Pedro Almeida: " + resultado);
    }

    private void carregarEmprestimos() {

        emprestimoController.cadastrarEmprestimo("Carlos Silva", "Harry Potter e a Pedra Filosofal");
        emprestimoController.cadastrarEmprestimo("Maria Oliveira", "1984");

        emprestimoController.cadastrarEmprestimo("Pedro Almeida", "Dom Casmurro");
    }

    private void carregarDevolucoes() {
        devolucaoController.registrarDevolucao("Maria Oliveira", "14/05/2025");

        devolucaoController.registrarDevolucao("Pedro Almeida", "22/05/2025");
    }
}
