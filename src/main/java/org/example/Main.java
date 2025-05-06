package org.example;

import Controllers.AutorController;
import Controllers.LivroController;
import Factory.AutorFactory;
import entities.Livro;

import java.lang.management.OperatingSystemMXBean;
import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        AutorFactory autorFactory = new AutorFactory();
        autorFactory.criarAutor("jose", "11/11/2011", "Alemão", "ATIVO");

        System.out.println(autorFactory.listarAutors());
        System.out.println(autorFactory.buscarAutor("jose"));

    }
}