package factory;

import controllers.AutorController;
import entities.Autor;
import enums.StatusAutor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class AutorFactory {
    private AutorController autorController;

    public AutorFactory() {
        autorController = new AutorController();
    }

    public void criarAutor(String nome, String dataNasc, String nacionalidade, String status) {
        LocalDate data = LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Autor autor = new Autor(nome.toUpperCase(), data, nacionalidade, StatusAutor.valueOf(status));
        autorController.cadastrarAutor(autor);
    }

    public void excluirAutor(String nome) {
        Optional<Autor> autor = autorController.getAutor(nome);
        if (autor.isPresent()) {
            autorController.excluirAutor(autor.get());
        }else{
            System.out.println("Autor inexistente");
        }
    }

    public void alterarAutor(String nome, String dataNasc, String nacionalidade, String status) {
        Optional<Autor> autor = autorController.getAutor(nome);
        LocalDate data = LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (autor.isPresent()) {
            autor.get().setNacionalidade(nacionalidade);
            autor.get().setDataNascimento(data);
            autor.get().setStatusAutor(StatusAutor.valueOf(status));
        }else{
            System.out.println("Autor inexistente");
        }
    }

    public boolean buscarAutor(String nome) {
        Optional<Autor> autor = autorController.getAutor(nome);
        if (autor.isPresent()) {
            return true;
        }else {
            return false;
        }
    }
}
