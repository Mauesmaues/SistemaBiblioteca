package controllers;

import entities.Autor;
import enums.StatusAutor;
import factory.AutorFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AutorController {
    private List<Autor> autors;

    public AutorController() {
        autors = new ArrayList<Autor>();
    }


    public String cadastrarAutor(String nome, String dataNasc, String nacionalidade, String status) {
        if(buscarAutor(nome).isEmpty()) {
            Optional<Autor> autorFactory = AutorFactory.criarAutor(nome, dataNasc, nacionalidade, status.toUpperCase());
            if(autorFactory.isPresent()){
                autors.add(autorFactory.get());
                return "Autor cadastrado com sucesso!";
            }
            return "Autor invalido!";
        }
        return "Autor ja existente!";
    }

    public String excluirAutor(String nome) {
        if(buscarAutor(nome).isEmpty()){
            return "Autor não encontrado!";
        }
        autors.remove(buscarAutor(nome).get());
        return "Autor excluido com sucesso!";
    }

    public void ordenarAutors(){
        Collections.sort(this.autors);
    }

    public Optional<Autor> buscarAutor(String nomeAutor) {
        for (Autor autor : autors) {
            if (autor.getNome().toUpperCase().equals(nomeAutor.toUpperCase())) {
                return Optional.of(autor);
            }
        }
        return Optional.empty();
    }


    public List<String> listarAutors() {
        return autors.stream().map(autor -> autor.getNome()).toList();
    }

    public String alterarAutor(String nome, String dataNasc, String nacionalidade, String status) {
        if(buscarAutor(nome).isEmpty()) {
            return "Autor não encontrado!";
        }
        Optional<Autor> autor = buscarAutor(nome);
        LocalDate data = LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (autor.isPresent()) {
            autor.get().setNacionalidade(nacionalidade);
            autor.get().setDataNascimento(data);
            autor.get().setStatusAutor(StatusAutor.valueOf(status));
        }
        return "Autor alterado com sucesso!";
    }
}
