package Factory;

import Controllers.AutorController;
import entities.Autors;
import enums.Status;
import enums.StatusAutor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class AutorFactory {
    private AutorController autorController;

    public AutorFactory() {
        autorController = new AutorController();
    }

    public void criarAutor(String nome, String dataNasc, String nacionalidade, String status) {
        LocalDate data = LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Autors autor = new Autors(nome, data, nacionalidade, StatusAutor.valueOf(status));
        autorController.cadastrarAutor(autor);
    }

    public void excluirAutor(String nome) {
        Optional<Autors> autor = autorController.getAutor(nome);
        if (autor.isPresent()) {
            autorController.excluirAutor(autor.get());
        }else{
            System.out.println("Autor inexistente");
        }
    }


}
