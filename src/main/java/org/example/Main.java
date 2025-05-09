package org.example;

import controllers.AutorController;

public class Main {
    public static void main(String[] args){
        AutorController autorController = new AutorController();
        String situacao = autorController.cadastrarAutor("batel", "22/08/2004", "brasileiro", "viado");
        System.out.println(situacao);
        System.out.println(autorController.listarAutors());
        System.out.println(autorController.getAutor("batel").get().getNome());


    }
}