package org.example;

import Controllers.LivroController;
import entities.Livro;

import java.lang.management.OperatingSystemMXBean;
import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Livro livro = new Livro("diario", "marcos", LocalDate.now(), 10);
        LivroController controller = new LivroController();
        controller.adicionarLivro(livro);
        Optional<Livro> livroPesq = controller.pesquisarLivroId(1);
        System.out.println(livroPesq.get().getTitulo());

    }
}