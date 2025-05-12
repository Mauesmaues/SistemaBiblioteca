package org.example;

import controllers.AutorController;
import controllers.CategoriaController;
import controllers.DevolucaoController;
import controllers.EmprestimoController;
import controllers.LivroController;
import controllers.UsuarioController;
import view.ViewGeral;

public class Main {

    public static void main(String[] args) {
        // Inicialização dos controllers
        AutorController autorController = new AutorController();
        CategoriaController categoriaController = new CategoriaController();
        LivroController livroController = new LivroController();
        UsuarioController usuarioController = new UsuarioController();
        EmprestimoController emprestimoController = new EmprestimoController();
        DevolucaoController devolucaoController = new DevolucaoController();

        // Realiza a pré-carga de dados para testes
        System.out.println("Iniciando pré-carga de dados para teste do sistema...");
        PreCarga preCarga = new PreCarga(autorController, categoriaController, livroController,
                usuarioController, emprestimoController, devolucaoController);

        // Inicializa a interface do usuário
        ViewGeral viewGeral = new ViewGeral(autorController, categoriaController, livroController,
                usuarioController, emprestimoController, devolucaoController);

        // Exibe o menu principal
        viewGeral.exibirMenuPrincipal();
    }
}
