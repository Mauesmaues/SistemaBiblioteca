package controllers;

import entities.Autor;
import enums.StatusAutor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AutorController {
    private List<Autor> autors;

    public AutorController() {
        autors = new ArrayList<Autor>();
    }


    public void cadastrarAutor(Autor autor) {

        autors.add(autor);
    }

    public void excluirAutor(Autor autor) {
        autors.remove(autor);
    }

    //public void ordenarAutors(){
    //    Collections.sort(autors);
    //}

    public Optional<Autor> getAutor(String nomeAutor) {
        for (Autor autor : autors) {
            if (autor.getNome().equals(nomeAutor)) {
                return Optional.of(autor);
            }
        }
        return Optional.empty();
    }


    public List<String> listarAutors() {
        return autors.stream().map(autor -> autor.getNome()).toList();
    }

    public boolean buscarAutor(String nome) {
        Optional<Autor> autor = getAutor(nome);
        if (autor.isPresent()) {
            return true;
        }else {
            return false;
        }
    }

    public void alterarAutor(String nome, String dataNasc, String nacionalidade, String status) {
        Optional<Autor> autor = getAutor(nome);
        LocalDate data = LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (autor.isPresent()) {
            autor.get().setNacionalidade(nacionalidade);
            autor.get().setDataNascimento(data);
            autor.get().setStatusAutor(StatusAutor.valueOf(status));
        }else{
            System.out.println("Autor inexistente");
        }
    }
}
