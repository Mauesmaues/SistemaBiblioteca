package controllers;

import model.Autor;
import enums.StatusAutor;
import factory.AutorFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AutorController {
    private static List<Autor> autors;

    public AutorController() {
        autors = new ArrayList<Autor>();
    }


    public String cadastrarAutor(String nome, String dataNasc, String nacionalidade, String status) {

        if(nome.isEmpty()){return "Campo nome em branco";}
        if(dataNasc.isEmpty()){return "Campo Data de Nascimento em branco";}
        if(!status.equalsIgnoreCase("ATIVO") && !status.equalsIgnoreCase("INATIVO") ){return "Status invalido!";}

        LocalDate data = LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if(data.getYear() > LocalDate.now().getYear()){return "Ano de nascimento invalido!";}
        if(buscarAutor(nome).isPresent()){ return "Autor ja existente!";}

        Autor autorFactory = AutorFactory.criarAutor(nome, data, nacionalidade, status.toUpperCase());

        autors.add(autorFactory);
        return "Autor cadastrado com sucesso!";
    }

    public String excluirAutor(String nome) {
        if(buscarAutor(nome).isEmpty()){return "Autor não encontrado!";}

        autors.remove(buscarAutor(nome).get());
        return "Autor excluido com sucesso!";
    }

    public void ordenarAutors(){
        Collections.sort(this.autors);
    }

    public static Optional<Autor> buscarAutor(String nomeAutor) {
        for (Autor autor : autors) {
            if (autor.getNome().toUpperCase().equalsIgnoreCase(nomeAutor)) {
                return Optional.of(autor);
            }
        }
        return Optional.empty();
    }

    public List<Autor> listarAutors() {
        return autors;
    }

    public String alterarAutor(String nome, String novoNome, String dataNasc, String nacionalidade, String status) {
        if(buscarAutor(nome).isEmpty()) {return "Autor não encontrado!";}
        if(novoNome.isEmpty()){return "Campo novo nome em branco!";}
        if(dataNasc.isEmpty()){return "Data de nascimento em branco!";}
        if(status.isEmpty()){return "Status em branco!";}

        Optional<Autor> autor = buscarAutor(nome);
        LocalDate data = LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (autor.isPresent()) {
            autor.get().setNome(novoNome);
            autor.get().setNacionalidade(nacionalidade);
            autor.get().setDataNascimento(data);
            autor.get().setStatusAutor(StatusAutor.valueOf(status));
        }
        return "Autor alterado com sucesso!";
    }
}
