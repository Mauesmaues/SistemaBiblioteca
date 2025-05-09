package factory;

import controllers.AutorController;
import entities.Autor;
import enums.StatusAutor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Pattern;

public final class AutorFactory {

        private static final AutorController autorController = new AutorController();

        public static Optional<Autor> criarAutor(String nome, String dataNasc, String nacionalidade, String status){

            if(nome.isEmpty() || dataNasc.isEmpty() || nacionalidade.isEmpty() || status.isEmpty()){
                return Optional.empty();
            }

            LocalDate data = LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            int anoNascInt = (int) data.getYear();


            if(anoNascInt > LocalDate.now().getYear()){
                return Optional.empty();
            }

            if(!status.equals("ATIVO") && !status.equals("INATIVO") ){
                return Optional.empty();
            }

            Autor autor = new Autor(nome, data, nacionalidade, StatusAutor.valueOf(status.toUpperCase()));
            return Optional.of(autor);
        }

}
