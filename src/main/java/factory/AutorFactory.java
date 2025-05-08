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

            String anoNasc = dataNasc.substring(6, 10);
            Pattern pattern = Pattern.compile("\\d+");
            int anoNascInt = Integer.parseInt(anoNasc);

            if(pattern.matcher(anoNasc).matches()){
                anoNascInt = Integer.parseInt(anoNasc);
            }else{return Optional.empty();}

            if(anoNascInt > LocalDate.now().minusYears(18).getYear()){
                return Optional.empty();
            }

            if(status.toUpperCase().equals("ATIVO") || status.toUpperCase().equals("INATIVO") ){
            }else{return Optional.empty();}

            LocalDate data = LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Autor autor = new Autor(nome, data, nacionalidade, StatusAutor.valueOf(status.toUpperCase()));
            return Optional.of(autor);
        }

}
