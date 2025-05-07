package org.example;

import factory.AutorFactory;

public class Main {
    public static void main(String[] args) {
        AutorFactory autorFactory = new AutorFactory();
        autorFactory.criarAutor("jose", "11/11/2011", "Alemão", "ATIVO");
        System.out.println(autorFactory.buscarAutor("jose"));

    }
}