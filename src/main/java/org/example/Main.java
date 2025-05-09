package org.example;

import controllers.AutorController;
import controllers.CategoriaController;

public class Main {
    public static void main(String[] args){
        AutorController autorController = new AutorController();
        String situacao = autorController.cadastrarAutor("Batel", "22/08/2004", "brasileiro", "ATIVO");
        autorController.cadastrarAutor("Igor", "22/08/2004", "brasileiro", "ATIVO");
        System.out.println(situacao);
        System.out.println(autorController.listarAutors());
        System.out.println(autorController.buscarAutor("BATEL").isPresent()?autorController.buscarAutor("batel").get():autorController.buscarAutor("batel"));

        CategoriaController categoriaController = new CategoriaController();
        situacao = categoriaController.cadastrarCategoria("Romance", "Nesse genero vc encontrara as melhores hisrorias de amor");
        System.out.println(situacao);
        System.out.println(categoriaController.listarCategorias());

    }
}