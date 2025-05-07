package Controllers;

import entities.Autor;

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
}
