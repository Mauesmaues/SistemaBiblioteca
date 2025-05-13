package factory;

import controllers.AutorController;
import model.Autor;
import enums.StatusAutor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public final class AutorFactory {

        private static final AutorController autorController = new AutorController();

        public static Autor criarAutor(String nome, LocalDate dataNasc, String nacionalidade, String status){

            return new Autor(nome, dataNasc, nacionalidade, StatusAutor.valueOf(status.toUpperCase()));
        }

}
