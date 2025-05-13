package application;

import config.PreCarga;
import controllers.*;
import view.ViewGeral;

public class App {

    public static void main(String[] args) {
        AutorController autorController = new AutorController();
        CategoriaController categoriaController = new CategoriaController();
        LivroController livroController = new LivroController();
        UsuarioController usuarioController = new UsuarioController();
        EmprestimoController emprestimoController = new EmprestimoController();
        DevolucaoController devolucaoController = new DevolucaoController();

        System.out.println("Iniciando pré-carga de dados para teste do sistema...");
        PreCarga preCarga = new PreCarga(autorController, categoriaController, livroController,
                usuarioController, emprestimoController, devolucaoController);

        ViewGeral viewGeral = new ViewGeral(autorController, categoriaController, livroController,
                usuarioController, emprestimoController, devolucaoController);

        viewGeral.exibirMenuPrincipal();
    }
}
